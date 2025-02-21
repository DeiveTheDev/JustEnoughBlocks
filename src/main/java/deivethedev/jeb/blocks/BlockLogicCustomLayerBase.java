package deivethedev.jeb.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;

public abstract class BlockLogicCustomLayerBase extends BlockLogic {
	public Block<?> fullBlock = null;
	public double height = 0.0625;

	public BlockLogicCustomLayerBase(Block<BlockLogicCustomLayerBase> block, double height, Block<?> fullBlock, Material material) {
		super(block, material);
		this.setBlockBounds((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)height, (double)1.0F);
		block.setBlockItem(() -> new ItemBlockCustomLayer<>(block));
		this.height = height;
		this.fullBlock = fullBlock;
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public AABB getBlockBoundsFromState(WorldSource world, int x, int y, int z) {
		int layer = ((world.getBlockMetadata(x, y, z) % 16) + 1);
		double f = (double) this.height * layer;
		return AABB.getPermanentBB((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)f, (double)1.0F);
	}
}
