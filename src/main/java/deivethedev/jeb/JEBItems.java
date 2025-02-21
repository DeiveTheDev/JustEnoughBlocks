package deivethedev.jeb;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDoorPainted;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.tag.ItemTags;
import turniplabs.halplibe.helper.ItemBuilder;
import static deivethedev.jeb.JEBBlocks.*;

import static deivethedev.jeb.JEBMain.LOGGER;
import static deivethedev.jeb.JEBMain.MOD_ID;

public class JEBItems {

	private static int startingID = JEBConfig.CFG.getInt("IDs.startingItemID");
	private static int nextID() {return startingID++;}

	public static ArmorMaterial oakBarkArmor;

	// Declaring items
	public static Item glassDoorPainted;

	public static void initItems() {

		glassDoorPainted = new ItemBuilder(MOD_ID)
			.addTags(ItemTags.NOT_IN_CREATIVE_MENU)
			.build(new ItemDoorPainted("door_glass_painted", MOD_ID + ":item/glass_door_painted", nextID(), glassDoorPaintedBottom, glassDoorPaintedTop));

		LOGGER.info("Items initialized.");
	}
}
