package deivethedev.jeb.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelStairsPainted;
import net.minecraft.client.render.block.model.BlockModelWool;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicStairs;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelStairsWool<T extends BlockLogicStairs> extends BlockModelStairsPainted<T> {

	public BlockModelStairsWool(Block<T> block) {
		super(block);
	}

	@Override
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
		meta >>= 4;
		return BlockModelWool.texCoords[meta & 15];
	}

}
