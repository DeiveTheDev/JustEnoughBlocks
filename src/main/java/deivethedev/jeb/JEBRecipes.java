package deivethedev.jeb;

import net.minecraft.client.gui.guidebook.RecipePage;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.lang.reflect.Array;

import static deivethedev.jeb.JEBBlocks.*;
import static deivethedev.jeb.JEBMain.LOGGER;
import static deivethedev.jeb.JEBMain.MOD_ID;

public class JEBRecipes implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {

		RecipeBuilder.getItemGroup(MOD_ID, "slab_wools");
		RecipeBuilder.addItemsToGroup(MOD_ID, "slab_wools",
			new ItemStack(slabWool, 1, 0), new ItemStack(slabWool, 1, 16), new ItemStack(slabWool, 1, 32), new ItemStack(slabWool, 1, 48),
			new ItemStack(slabWool, 1, 64), new ItemStack(slabWool, 1, 80), new ItemStack(slabWool, 1, 96), new ItemStack(slabWool, 1, 112),
			new ItemStack(slabWool, 1, 128), new ItemStack(slabWool, 1, 144), new ItemStack(slabWool, 1, 160), new ItemStack(slabWool, 1, 176),
			new ItemStack(slabWool, 1, 192), new ItemStack(slabWool, 1, 208), new ItemStack(slabWool, 1, 224), new ItemStack(slabWool, 1, 240)
		);

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"SSS")
			.addInput('S', Blocks.SLATE_POLISHED)
			.create("slab_slate_carved", new ItemStack(slabSlatePolished, 6));



		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 0)
			.create("slab_white_wool", new ItemStack(slabWool, 6, 0));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 1)
			.create("slab_orange_wool", new ItemStack(slabWool, 6, 16));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 2)
			.create("slab_magenta_wool", new ItemStack(slabWool, 6, 32));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 3)
			.create("slab_lightblue_wool", new ItemStack(slabWool, 6, 48));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 4)
			.create("slab_yellow_wool", new ItemStack(slabWool, 6, 64));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 5)
			.create("slab_lime_wool", new ItemStack(slabWool, 6, 80));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 6)
			.create("slab_pink_wool", new ItemStack(slabWool, 6, 96));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 7)
			.create("slab_gray_wool", new ItemStack(slabWool, 6, 112));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 8)
			.create("slab_silver_wool", new ItemStack(slabWool, 6, 128));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 9)
			.create("slab_cyan_wool", new ItemStack(slabWool, 6, 144));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 10)
			.create("slab_purple_wool", new ItemStack(slabWool, 6, 160));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 11)
			.create("slab_blue_wool", new ItemStack(slabWool, 6, 176));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 12)
			.create("slab_brown_wool", new ItemStack(slabWool, 6, 192));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 13)
			.create("slab_green_wool", new ItemStack(slabWool, 6, 208));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 14)
			.create("slab_red_wool", new ItemStack(slabWool, 6, 224));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"WWW")
			.addInput('W', Blocks.WOOL, 15)
			.create("slab_black_wool", new ItemStack(slabWool, 6, 240));



		RecipeBuilder.Shapeless(MOD_ID) // WHITE
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 15)
			.create("slab_white_wool", new ItemStack(slabWool, 2, 0));

		RecipeBuilder.Shapeless(MOD_ID) // ORANGE
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 14)
			.create("slab_orange_wool", new ItemStack(slabWool, 2, 16));

		RecipeBuilder.Shapeless(MOD_ID) // MAGENTA
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 13)
			.create("slab_magenta_wool", new ItemStack(slabWool, 2, 32));

		RecipeBuilder.Shapeless(MOD_ID) // LIGHT BLUE
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 12)
			.create("slab_lightblue_wool", new ItemStack(slabWool, 2, 48));

		RecipeBuilder.Shapeless(MOD_ID) // YELLOW
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 11)
			.create("slab_black_wool", new ItemStack(slabWool, 2, 64));

		RecipeBuilder.Shapeless(MOD_ID) // LIME
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 10)
			.create("slab_lime_wool", new ItemStack(slabWool, 2, 80));

		RecipeBuilder.Shapeless(MOD_ID) // PINK
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 9)
			.create("slab_wool_pink", new ItemStack(slabWool, 2, 96));

		RecipeBuilder.Shapeless(MOD_ID) // GRAY
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 8)
			.create("slab_wool_gray", new ItemStack(slabWool, 2, 112));

		RecipeBuilder.Shapeless(MOD_ID) // SILVER
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 7)
			.create("slab_wool_silver", new ItemStack(slabWool, 2, 128));

		RecipeBuilder.Shapeless(MOD_ID) // CYAN
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 6)
			.create("slab_wool_cyan", new ItemStack(slabWool, 2, 144));

		RecipeBuilder.Shapeless(MOD_ID) // PURPLE
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 5)
			.create("slab_wool_purple", new ItemStack(slabWool, 2, 160));

		RecipeBuilder.Shapeless(MOD_ID) // BLUE
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 4)
			.create("slab_wool_blue", new ItemStack(slabWool, 2, 176));

		RecipeBuilder.Shapeless(MOD_ID) // BROWN
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 3)
			.create("slab_wool_black", new ItemStack(slabWool, 2, 192));

		RecipeBuilder.Shapeless(MOD_ID) // GREEN
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 2)
			.create("slab_wool_green", new ItemStack(slabWool, 2, 208));

		RecipeBuilder.Shapeless(MOD_ID) // RED
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 1)
			.create("slab_wool_black", new ItemStack(slabWool, 2, 224));

		RecipeBuilder.Shapeless(MOD_ID) // BLACK
			.addInput("jeb:slab_wools")
			.addInput("jeb:slab_wools")
			.addInput(Items.DYE, 0)
			.create("slab_wool_black", new ItemStack(slabWool, 2, 240));

		LOGGER.info("Recipes initialized.");
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}

}
