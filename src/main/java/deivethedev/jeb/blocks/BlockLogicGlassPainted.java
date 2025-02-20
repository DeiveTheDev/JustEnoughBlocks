

package deivethedev.jeb.blocks;

import net.minecraft.client.render.block.model.BlockModelWool;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockLogicGlassPainted extends BlockLogicGlass implements IPainted {

	public BlockLogicGlassPainted(Block<?> block, Material material) {
		super(block, material);
	}

	public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		return stack.getMetadata();
	}

	public DyeColor fromMetadata(int meta) {
		return DyeColor.colorFromBlockMeta(meta);
	}

	public int toMetadata(DyeColor color) {
		return color.blockMeta;
	}

	public int stripColorFromMetadata(int meta) {
		return meta & 15;
	}

	public void removeDye(World world, int x, int y, int z) {
		world.setBlockWithNotify(x, y, z, Blocks.GLASS.id());
	}

	public void setColor(World world, int x, int y, int z, DyeColor color) {
		IPainted.super.setColor(world, x, y, z, color);
	}

	public String getLanguageKey(int meta) {
		return super.getLanguageKey(meta) + "." + this.fromMetadata(meta).colorID;
	}
}
