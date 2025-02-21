package deivethedev.jeb;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DyeColor;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static deivethedev.jeb.JEBBlocks.*;
import static deivethedev.jeb.JEBItems.*;
import static deivethedev.jeb.JEBMain.LOGGER;
import static deivethedev.jeb.JEBMain.MOD_ID;

public class JEBRecipes implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {

		RecipeBuilder.getItemGroup(MOD_ID, "slab_wools");
		RecipeBuilder.getItemGroup(MOD_ID, "painted_slab_wools");

		RecipeBuilder.getItemGroup(MOD_ID, "stairs_wools");
		RecipeBuilder.getItemGroup(MOD_ID, "painted_stairs_wools");

		RecipeBuilder.getItemGroup(MOD_ID, "carpets");
		RecipeBuilder.getItemGroup(MOD_ID, "painted_carpets");

		RecipeBuilder.getItemGroup(MOD_ID, "glasses");
		RecipeBuilder.getItemGroup(MOD_ID, "painted_glasses");

		RecipeBuilder.getItemGroup(MOD_ID, "glass_doors");
		RecipeBuilder.getItemGroup(MOD_ID, "painted_glass_doors");

		RecipeBuilder.getItemGroup(MOD_ID, "glass_trapdoors");
		RecipeBuilder.getItemGroup(MOD_ID, "painted_glass_trapdoors");

		RecipeBuilder.addItemsToGroup(MOD_ID, "glasses", Blocks.GLASS);
		RecipeBuilder.addItemsToGroup(MOD_ID, "glass_doors", Items.DOOR_GLASS);
		RecipeBuilder.addItemsToGroup(MOD_ID, "glass_trapdoors", Blocks.TRAPDOOR_GLASS);

		for (DyeColor color : DyeColor.blockOrderedColors()) {

			if (color.blockMeta != 0) {
				RecipeBuilder.addItemsToGroup(MOD_ID, "painted_slab_wools", new ItemStack(slabWool, 1, color.blockMeta << 4));
				RecipeBuilder.addItemsToGroup(MOD_ID, "painted_stairs_wools", new ItemStack(stairWool, 1, color.blockMeta << 4));
				RecipeBuilder.addItemsToGroup(MOD_ID, "painted_carpets", new ItemStack(carpet, 1, color.blockMeta << 4));
			}

			RecipeBuilder.addItemsToGroup(MOD_ID, "slab_wools", new ItemStack(slabWool, 1, color.blockMeta << 4));
			RecipeBuilder.addItemsToGroup(MOD_ID, "stairs_wools", new ItemStack(stairWool, 1, color.blockMeta << 4));
			RecipeBuilder.addItemsToGroup(MOD_ID, "carpets", new ItemStack(carpet, 1, color.blockMeta << 4));

			RecipeBuilder.addItemsToGroup(MOD_ID, "glasses", new ItemStack(glassPainted, 1, color.blockMeta));
			RecipeBuilder.addItemsToGroup(MOD_ID, "painted_glasses", new ItemStack(glassPainted, 1, color.blockMeta));

			RecipeBuilder.addItemsToGroup(MOD_ID, "glass_doors", new ItemStack(glassDoorPainted, 1, color.itemMeta));
			RecipeBuilder.addItemsToGroup(MOD_ID, "painted_glass_doors", new ItemStack(glassDoorPainted, 1, color.itemMeta));

			RecipeBuilder.addItemsToGroup(MOD_ID, "glass_trapdoors", new ItemStack(glassTrapdoorPainted, 1, color.blockMeta << 4));
			RecipeBuilder.addItemsToGroup(MOD_ID, "painted_glass_trapdoors", new ItemStack(glassTrapdoorPainted, 1, color.blockMeta << 4));
		}



		for (DyeColor color : DyeColor.blockOrderedColors()) {

			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"WWW")
				.addInput('W', Blocks.WOOL, color.blockMeta)
				.create("slab_" + color.colorID + "_wool", new ItemStack(slabWool, 6, color.blockMeta << 4));

			RecipeBuilder.Shapeless(MOD_ID)
				.addInput("jeb:slab_wools")
				.addInput("jeb:slab_wools")
				.addInput(Items.DYE, color.itemMeta)
				.create("slab_" + color.colorID + "_wool_2", new ItemStack(slabWool, 2, color.blockMeta << 4));



			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"WW")
				.addInput('W', Blocks.WOOL, color.blockMeta)
				.create("carpet_" + color.colorID, new ItemStack(carpet, 8, color.blockMeta << 4));

			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"CCC",
					"CDC",
					"CCC")
				.addInput('C', "jeb:carpets")
				.addInput('D', Items.DYE, color.itemMeta)
				.create("carpet_" + color.colorID + "_2", new ItemStack(carpet, 8, color.blockMeta << 4));



			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"W  ",
					"WW ",
					"WWW")
				.addInput('W', Blocks.WOOL, color.blockMeta)
				.create("stairs_" + color.colorID + "_wool", new ItemStack(stairWool, 6, color.blockMeta << 4));

			RecipeBuilder.Shapeless(MOD_ID)
				.addInput("jeb:stairs_wools")
				.addInput(Items.DYE, color.itemMeta)
				.create("stairs_" + color.colorID + "_wool_2", new ItemStack(stairWool, 1, color.blockMeta << 4));



			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"GGG",
					"GDG",
					"GGG")
				.addInput('G', "jeb:glasses")
				.addInput('D', Items.DYE, color.itemMeta)
				.create("painted_" + color.colorID + "_glass", new ItemStack(glassPainted, 8, color.blockMeta));

			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"GGG",
					"GGG")
				.addInput('G', glassPainted, color.blockMeta)
				.create("painted_" + color.colorID + "_glass_trapdoor", new ItemStack(glassTrapdoorPainted, 6, color.blockMeta));

			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"GGG",
					"GDG",
					"GGG")
				.addInput('G', "jeb:glass_trapdoors")
				.addInput('D', Items.DYE, color.itemMeta)
				.create("painted_" + color.colorID + "_glass_trapdoor_2", new ItemStack(glassTrapdoorPainted, 8, color.blockMeta << 4));

			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"GG ",
					"GG ",
					"GG ")
				.addInput('G', glassPainted, color.blockMeta)
				.create("painted_" + color.colorID + "_glass_door", new ItemStack(glassDoorPainted, 2, color.itemMeta));

			RecipeBuilder.Shaped(MOD_ID)
				.setShape(
					"GGG",
					"GDG",
					"GGG")
				.addInput('G', "jeb:glass_doors")
				.addInput('D', Items.DYE, color.itemMeta)
				.create("painted_" + color.colorID + "_glass_door_2", new ItemStack(glassDoorPainted, 8, color.itemMeta));
		}

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"CCC",
				"CWC",
				"CCC")
			.addInput('C', "jeb:painted_carpets")
			.addInput('W', Blocks.SPONGE_WET)
			.create("painted_to_carpet", new ItemStack(carpet, 8, 0));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"SSS",
				"SWS",
				"SSS")
			.addInput('S', "jeb:painted_slab_wools")
			.addInput('W', Blocks.SPONGE_WET)
			.create("painted_to_slab_wool", new ItemStack(slabWool, 8, 0));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"SSS",
				"SWS",
				"SSS")
			.addInput('S', "jeb:painted_stairs_wools")
			.addInput('W', Blocks.SPONGE_WET)
			.create("painted_to_stairs_wool", new ItemStack(stairWool, 8, 0));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"GGG",
				"GWG",
				"GGG")
			.addInput('G', "jeb:painted_glasses")
			.addInput('W', Blocks.SPONGE_WET)
			.create("painted_to_glass", new ItemStack(Blocks.GLASS, 8));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"GGG",
				"GWG",
				"GGG")
			.addInput('G', "jeb:painted_glass_doors")
			.addInput('W', Blocks.SPONGE_WET)
			.create("painted_to_glass_door", new ItemStack(Items.DOOR_GLASS, 8));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"GGG",
				"GWG",
				"GGG")
			.addInput('G', "jeb:painted_glass_trapdoors")
			.addInput('W', Blocks.SPONGE_WET)
			.create("painted_to_glass_trapdoor", new ItemStack(Blocks.TRAPDOOR_GLASS, 8));



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
