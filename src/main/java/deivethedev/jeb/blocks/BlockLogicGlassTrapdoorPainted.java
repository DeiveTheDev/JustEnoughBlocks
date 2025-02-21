package deivethedev.jeb.blocks;

import deivethedev.jeb.JEBBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicTrapDoorPainted;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockLogicGlassTrapdoorPainted extends BlockLogicTrapDoorPainted implements IPainted {

	public BlockLogicGlassTrapdoorPainted(Block<?> block, Material material) {
		super(block, material);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(JEBBlocks.glassTrapdoorPainted, 1, (meta >> 4 & 15) << 4)};
	}

	@Override
	public boolean canBePainted() {
		return this.material == Material.glass;
	}

	public void removeDye(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		world.setBlockAndMetadataWithNotify(x, y, z, JEBBlocks.glassTrapdoorPainted.id(), meta & 15);
	}

	public String getLanguageKey(int meta) {
		return super.getLanguageKey(meta) + "." + this.fromMetadata(meta).colorID;
	}
}
