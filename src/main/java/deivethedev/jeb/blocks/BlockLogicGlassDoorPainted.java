package deivethedev.jeb.blocks;

import deivethedev.jeb.JEBBlocks;
import deivethedev.jeb.JEBItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicDoorPainted;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.world.World;

public class BlockLogicGlassDoorPainted extends BlockLogicDoorPainted implements IPainted {

	public BlockLogicGlassDoorPainted(Block<?> block, Material material, boolean isTop) {
		super(block, material, isTop);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(JEBItems.glassDoorPainted, 1, 15 - (meta >> 4 & 15))};
	}

	@Override
	public boolean canBePainted() {
		return this.material == Material.glass;
	}

	@Override
	public void removeDye(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		world.setBlockAndMetadataWithNotify(x, y, z, this.isTop ? JEBBlocks.glassDoorPaintedTop.id() : JEBBlocks.glassDoorPaintedBottom.id(), meta & 15);
		if (this.isTop) {
			world.setBlockAndMetadataWithNotify(x, y - 1, z, JEBBlocks.glassDoorPaintedBottom.id(), meta & 15);
		} else {
			world.setBlockAndMetadataWithNotify(x, y + 1, z, JEBBlocks.glassDoorPaintedTop.id(), meta & 15);
		}
	}

	@Override
	public void setColor(World world, int x, int y, int z, DyeColor color) {
		int meta = world.getBlockMetadata(x, y, z);
		world.setBlockMetadataWithNotify(x, y, z, meta & 15 | this.toMetadata(color));
		if (this.isTop) {
			world.setBlockMetadataWithNotify(x, y - 1, z, meta & 15 | this.toMetadata(color));
		} else {
			world.setBlockMetadataWithNotify(x, y + 1, z, meta & 15 | this.toMetadata(color));
		}
	}

	public String getLanguageKey(int meta) {
		return super.getLanguageKey(meta) + "." + this.fromMetadata(meta).colorID;
	}
}
