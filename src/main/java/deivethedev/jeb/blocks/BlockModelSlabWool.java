package deivethedev.jeb.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelSlabPainted;
import net.minecraft.client.render.block.model.BlockModelWool;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.*;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

@Environment(EnvType.CLIENT)
public class BlockModelSlabWool<T extends BlockLogicSlab> extends BlockModelSlabPainted<T> {

	public BlockModelSlabWool(Block<T> block) {
		super(block);
	}

	@Override
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
		meta >>= 4;
		return BlockModelWool.texCoords[meta & 15];
	}

}
