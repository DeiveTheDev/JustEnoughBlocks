package deivethedev.jeb.mixin;

import net.minecraft.core.block.*;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockLogicStairsPainted.class)
public class BlockLogicStairsPaintedMixin extends BlockLogicStairs implements IPainted {

	public BlockLogicStairsPaintedMixin(Block<?> block, Block<?> modelBlock) {
		super(block, modelBlock);
	}

	public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		return stack.getMetadata();
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
		int meta = world.getBlockMetadata(x, y, z);
		world.setBlockAndMetadataWithNotify(x, y, z, Blocks.STAIRS_PLANKS_OAK.id(), this.stripColorFromMetadata(meta));
	}

	public void setColor(World world, int x, int y, int z, DyeColor color) {
		IPainted.super.setColor(world, x, y, z, color);
	}
}
