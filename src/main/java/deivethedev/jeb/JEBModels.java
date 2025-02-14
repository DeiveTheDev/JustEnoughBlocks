package deivethedev.jeb;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static deivethedev.jeb.JEBBlocks.*;
import static deivethedev.jeb.JEBMain.LOGGER;
import static deivethedev.jeb.JEBMain.MOD_ID;

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



		LOGGER.info("Block Models initialized.");
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {

		LOGGER.info("Item Models initialized.");
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {}
}
