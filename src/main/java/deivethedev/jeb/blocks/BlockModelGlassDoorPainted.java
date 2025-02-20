package deivethedev.jeb.blocks;

import net.minecraft.client.render.block.model.BlockModelDoorPainted;
import net.minecraft.client.render.block.model.BlockModelTrapDoorPainted;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicDoor;
import net.minecraft.core.block.BlockLogicTrapDoor;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;

public class BlockModelGlassDoorPainted<T extends BlockLogicDoor> extends BlockModelDoorPainted<T> {
	public static final IconCoordinate[] doorBottomTextures = new IconCoordinate[16];
	public static final IconCoordinate[] doorTopTextures = new IconCoordinate[16];
	public static final IconCoordinate[] frameTopTextures = new IconCoordinate[16];
	private final boolean isTop;

	public BlockModelGlassDoorPainted(Block<T> block, boolean isTop1) {
		super(block, isTop1);
		this.isTop = isTop1;
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		int color = data >> 4 & 15;
		if (side.getAxis() == Axis.Y) {
			return frameTopTextures[color];
		} else {
			return this.isTop ? doorTopTextures[color] : doorBottomTextures[color];
		}
	}

	static {
		for(DyeColor c : DyeColor.blockOrderedColors()) {
			doorTopTextures[c.blockMeta] = TextureRegistry.getTexture("jeb:block/door/glass/" + c.colorID + "_top");
			doorBottomTextures[c.blockMeta] = TextureRegistry.getTexture("jeb:block/door/glass/" + c.colorID + "_bottom");
			frameTopTextures[c.blockMeta] = TextureRegistry.getTexture("jeb:block/door/glass/" + c.colorID + "_frame_top");
		}

	}
}
