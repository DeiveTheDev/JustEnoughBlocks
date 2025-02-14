package deivethedev.jeb.mixin;

import deivethedev.jeb.JEBBlocks;
import net.minecraft.core.block.*;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Supplier;

@Mixin(BlockLogicMoss.class)
public abstract class MossMixin extends BlockLogic implements IBonemealable {

	public MossMixin(Block<?> block, Material material) {
		super(block, material);
	}

	@Override
	public ItemStack @Nullable [] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {

		@Nullable Supplier<? extends IItemConvertible> crushDrop = null;

		if (block.id() == Blocks.MOSS_STONE.id()) {
			crushDrop = () -> Blocks.COBBLE_STONE_MOSSY;
		} else if (block.id() == Blocks.MOSS_BASALT.id()) {
			crushDrop = () ->  JEBBlocks.cobbleBasaltMossy;
		} else if (block.id() == Blocks.MOSS_GRANITE.id()) {
			crushDrop = () ->  JEBBlocks.cobbleGraniteMossy;
		} else if (block.id() == Blocks.MOSS_LIMESTONE.id()) {
			crushDrop = () ->  JEBBlocks.cobbleLimestoneMossy;
		}
		return crushDrop != null && dropCause == EnumDropCause.PISTON_CRUSH ? new ItemStack[]{new ItemStack((IItemConvertible) crushDrop.get())} : super.getBreakResult(world, dropCause, meta, tileEntity);
	}

}
