package deivethedev.jeb.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLayerBase;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class ItemBlockCustomLayer<T extends BlockLogicCustomLayerBase> extends ItemBlock<T> {

	public ItemBlockCustomLayer(Block<T> block) {
		super(block);
	}

	public boolean onUseItemOnBlock(ItemStack itemstack, @Nullable Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		Block<?> targetBlock = world.getBlock(blockX, blockY, blockZ);
		int meta = world.getBlockMetadata(blockX, blockY, blockZ);
		if (targetBlock != this.block && targetBlock != null && targetBlock.hasTag(BlockTags.PLACE_OVERWRITES)) {
			targetBlock = null;
			meta = 0;
		}

		if (itemstack.stackSize <= 0) {
			return false;
		} else if (blockY == world.getHeightBlocks() - 1 && this.block.getMaterial().isSolid()) {
			return false;
		} else if (targetBlock == this.block && side == Side.TOP) {

			if (itemstack.getMetadata() != meta - (meta % 16)) {
				System.out.println(meta);
				return false;
			}

			BlockLogicCustomLayerBase blockLayer = (BlockLogicCustomLayerBase)this.block.getLogic();
			int newMeta = meta + 1;
			AABB bbBox = AABB.getTemporaryBB((double)blockX, (double)blockY, (double)blockZ, (double)((float)blockX + 1.0F), (double)((float)blockY + (float)(blockLayer.height * (newMeta + 1)) / 16.0F), (double)((float)blockZ + 1.0F));
			if (!world.checkIfAABBIsClear(bbBox)) {
				return false;
			} else {
				System.out.println("first");

				if (meta % 16 < 15) {
					System.out.println("1");
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, this.block.id(), newMeta);
					System.out.println(world.getBlockMetadata(blockX, blockY, blockZ));
				} else if (blockLayer.fullBlock != null) {
					System.out.println("2");
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockLayer.fullBlock.id(), 0);
				} else {
					System.out.println("3");
					world.setBlockAndMetadataWithNotify(blockX, blockY + 1, blockZ, this.block.id(), meta - (meta % 16));
				}

				world.playBlockSoundEffect(player, (double)((float)blockX + 0.5F), (double)((float)blockY + 0.5F), (double)((float)blockZ + 0.5F), this.block, EnumBlockSoundEffectType.PLACE);
				itemstack.consumeItem(player);
				return true;
			}
		} else {
			if (targetBlock != null) {
				blockX += side.getOffsetX();
				blockY += side.getOffsetY();
				blockZ += side.getOffsetZ();
				targetBlock = world.getBlock(blockX, blockY, blockZ);
				meta = world.getBlockMetadata(blockX, blockY, blockZ);
			}

			if (targetBlock == this.block) {
				BlockLogicCustomLayerBase blockLayer = (BlockLogicCustomLayerBase)this.block.getLogic();
				int newMeta = meta + 1;
				AABB bbBox = AABB.getTemporaryBB((double)blockX, (double)blockY, (double)blockZ, (double)((float)blockX + 1.0F), (double)((float)blockY + (float)(blockLayer.height * (newMeta + 1)) / 16.0F), (double)((float)blockZ + 1.0F));
				if (!world.checkIfAABBIsClear(bbBox)) {
					return false;
				} else {
					System.out.println("second");
					if (newMeta % 16 < 15) {
						world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, this.block.id(), newMeta);
					} else if (blockLayer.fullBlock != null) {
						world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, blockLayer.fullBlock.id(), 0);
					} else {
						world.setBlockAndMetadataWithNotify(blockX, blockY + 1, blockZ, this.block.id(), meta - (meta % 16));
					}

					world.playBlockSoundEffect(player, (double)((float)blockX + 0.5F), (double)((float)blockY + 0.5F), (double)((float)blockZ + 0.5F), this.block, EnumBlockSoundEffectType.PLACE);
					itemstack.consumeItem(player);
					return true;
				}
			} else {
				if (world.canBlockBePlacedAt(this.block.id(), blockX, blockY, blockZ, false, side)) {
					System.out.println("last");
					int placeMeta = this.getPlacedBlockMetadata(player, itemstack, world, blockX, blockY, blockZ, side, xPlaced, yPlaced);
					if (world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, this.block.id(), placeMeta)) {
						if (player == null) {
							this.block.onBlockPlacedOnSide(world, blockX, blockY, blockZ, side, xPlaced, yPlaced);
						} else {
							this.block.onBlockPlacedByMob(world, blockX, blockY, blockZ, Side.NONE, player, xPlaced, yPlaced);
						}

						world.playBlockSoundEffect(player, (double)((float)blockX + 0.5F), (double)((float)blockY + 0.5F), (double)((float)blockZ + 0.5F), this.block, EnumBlockSoundEffectType.PLACE);
						itemstack.consumeItem(player);
						return true;
					}
				}

				return false;
			}
		}
	}
}

