package deivethedev.jeb;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static deivethedev.jeb.JEBBlocks.*;
import static deivethedev.jeb.JEBMain.LOGGER;
import static deivethedev.jeb.JEBMain.MOD_ID;

public class JEBRecipes implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"SSS")
			.addInput('S', Blocks.SLATE_POLISHED)
			.create("slab_slate_carved", new ItemStack(slabSlatePolished, 6));

		LOGGER.info("Recipes initialized.");
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}

}
