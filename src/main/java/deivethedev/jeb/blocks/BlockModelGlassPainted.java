package deivethedev.jeb.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelTransparent;
import net.minecraft.client.render.block.model.BlockModelWool;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelGlassPainted<T extends BlockLogic> extends BlockModelTransparent<T> {
	public static final IconCoordinate[] texCoords = new IconCoordinate[16];

	public BlockModelGlassPainted(Block<T> block, boolean renderInside) {
		super(block, renderInside);
	}

	@Override
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
		return texCoords[meta & 15];
	}

	static {
		for(DyeColor c : DyeColor.blockOrderedColors()) {
			texCoords[c.blockMeta] = TextureRegistry.getTexture("jeb:block/glass/" + c.colorID);
		}
	}
}
