package deivethedev.jeb;

import deivethedev.jeb.blocks.*;
import deivethedev.jeb.items.ItemModelGlassDoorPainted;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static deivethedev.jeb.JEBBlocks.*;
import static deivethedev.jeb.JEBItems.*;
import static deivethedev.jeb.JEBMain.LOGGER;

public class JEBModels implements ModelEntrypoint {

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

		ModelHelper.setBlockModel(cobbleBasaltMossy, () -> new BlockModelStandard<>(cobbleBasaltMossy)
			.setTex(0, cobbleBasaltMossy.namespaceId().toString(), Side.sides)
		);

		ModelHelper.setBlockModel(cobbleGraniteMossy, () -> new BlockModelStandard<>(cobbleGraniteMossy)
			.setTex(0, cobbleGraniteMossy.namespaceId().toString(), Side.sides)
		);

		ModelHelper.setBlockModel(cobbleLimestoneMossy, () -> new BlockModelStandard<>(cobbleLimestoneMossy)
			.setTex(0, cobbleLimestoneMossy.namespaceId().toString(), Side.sides)
		);

		ModelHelper.setBlockModel(slateCarved, () -> new BlockModelStandard<>(slateCarved)
			.setTex(0, slateCarved.namespaceId() + "_top", Side.TOP, Side.BOTTOM)
			.setTex(0, slateCarved.namespaceId() + "_side", Side.NORTH, Side.SOUTH, Side.EAST, Side.WEST)
		);

		ModelHelper.setBlockModel(slabSlatePolished, () -> new BlockModelSlab<>(slabSlatePolished)
			.setTex(0, slateCarved.namespaceId() + "_top", Side.TOP, Side.BOTTOM)
			.setTex(0, slateCarved.namespaceId() + "_side", Side.NORTH, Side.SOUTH, Side.EAST, Side.WEST)
		);

		ModelHelper.setBlockModel(slabWool, () -> new BlockModelSlabWool<>(slabWool)
		);

		ModelHelper.setBlockModel(stairWool, () -> new BlockModelStairsWool<>(stairWool)
		);

		ModelHelper.setBlockModel(carpet, () -> new BlockModelCarpet<>(carpet)
			.setTex(0, "minecraft:block/wool/white", Side.sides)
		);

		ModelHelper.setBlockModel(glassPainted, () -> new BlockModelGlassPainted<>(glassPainted, false)
			.onRenderLayer(1)
		);

		ModelHelper.setBlockModel(glassDoorPaintedTop, () -> new BlockModelGlassDoorPainted<>(glassDoorPaintedTop, true)
			.onRenderLayer(1)
		);

		ModelHelper.setBlockModel(glassDoorPaintedBottom, () -> new BlockModelGlassDoorPainted<>(glassDoorPaintedBottom, false)
			.onRenderLayer(1)
		);

		ModelHelper.setBlockModel(glassTrapdoorPainted, () -> new BlockModelGlassTrapdoorPainted<>(glassTrapdoorPainted)
			.onRenderLayer(1)
		);

		LOGGER.info("Block Models initialized.");
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {

		ModelHelper.setItemModel(glassDoorPainted, () -> {
			ItemModelStandard model = new ItemModelGlassDoorPainted(glassDoorPainted);
			model.icon = TextureRegistry.getTexture(glassDoorPainted.namespaceID);
			return model;
		});

		LOGGER.info("Item Models initialized.");
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {}
}
