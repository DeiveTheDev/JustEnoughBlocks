package deivethedev.jeb.blocks;

import net.minecraft.core.block.*;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;


public class BlockLogicCarpet extends BlockLogicCustomLayerBase implements IPainted {

	public BlockLogicCarpet(Block<BlockLogicCustomLayerBase> block, double height, Block<?> fullBlock, Material material) {
		super(block, height, fullBlock, material);
		this.setBlockBounds((double)(0.0F), (double)0.0F, (double)(0.0F), (double)(1.0F), (double)0.0625F, (double)(1.0F ));
	}

	public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		return stack.getMetadata();
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case EXPLOSION:
			case PROPER_TOOL:
				return new ItemStack[]{new ItemStack((IItemConvertible) this, meta % 16 + 1, meta - meta % 16)};
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack((IItemConvertible) this, 1, meta - meta % 16)};
			default:
				return null;
		}
	}

	public DyeColor fromMetadata(int meta) {
		return DyeColor.colorFromBlockMeta((meta & 240) >> 4);
	}

	public int toMetadata(DyeColor color) {
		return color.blockMeta << 4;
	}

	public int stripColorFromMetadata(int meta) {
		return meta & 15;
	}

	public void removeDye(World world, int x, int y, int z) {
		world.setBlockWithNotify(x, y, z, Blocks.WOOL.id());
	}

	public void setColor(World world, int x, int y, int z, DyeColor color) {
		IPainted.super.setColor(world, x, y, z, color);
	}

	public String getLanguageKey(int meta) {
		return super.getLanguageKey(meta) + "." + this.fromMetadata(meta).colorID;
	}
}
