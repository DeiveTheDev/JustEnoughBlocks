package deivethedev.jeb.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelTrapDoorPainted;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicTrapDoor;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;

@Environment(EnvType.CLIENT)
public class BlockModelGlassTrapdoorPainted <T extends BlockLogicTrapDoor> extends BlockModelTrapDoorPainted<T> {
	public static final IconCoordinate[] topTextures = new IconCoordinate[16];
	public static final IconCoordinate[] sideTextures = new IconCoordinate[16];

	public BlockModelGlassTrapdoorPainted(Block<T> block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		int color = data >> 4 & 15;
		int orientation = data & 3;
		if (BlockLogicTrapDoor.isTrapdoorOpen(data)) {
			int index = Sides.orientationLookUpTrapdoorOpen[6 * orientation + side.getId()];
			return index < 2 ? topTextures[color] : sideTextures[color];
		} else {
			return side.getAxis() == Axis.Y ? topTextures[color] : sideTextures[color];
		}
	}

	static {
		for(DyeColor c : DyeColor.blockOrderedColors()) {
			topTextures[c.blockMeta] = TextureRegistry.getTexture("jeb:block/trapdoor/glass/" + c.colorID + "_top");
			sideTextures[c.blockMeta] = TextureRegistry.getTexture("jeb:block/trapdoor/glass/" + c.colorID + "_side");
		}

	}
}
