package deivethedev.jeb.mixin;

import deivethedev.jeb.JEBBlocks;
import deivethedev.jeb.blocks.BlockLogicGlassPainted;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;



@Mixin(BlockLogicGlass.class)
public class BlockLogicGlassMixin extends BlockLogicTransparent implements IPaintable {

	public BlockLogicGlassMixin(Block<?> block, Material material) {
		super(block, material);
	}

	public boolean canBePainted() {
		return this.material == Material.glass;
	}

	public void setColor(World world, int x, int y, int z, DyeColor color) {
		world.setBlock(x, y, z, JEBBlocks.glassPainted.id());
		((BlockLogicGlassPainted) JEBBlocks.glassPainted.getLogic()).setColor(world, x, y, z, color);
	}
}
