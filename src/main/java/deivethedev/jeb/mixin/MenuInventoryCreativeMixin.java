package deivethedev.jeb.mixin;

import deivethedev.jeb.JEBBlocks;
import deivethedev.jeb.JEBItems;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuInventory;
import net.minecraft.core.player.inventory.menu.MenuInventoryCreative;
import net.minecraft.core.util.helper.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.player.inventory.menu.MenuInventoryCreative.creativeItems;
import static net.minecraft.core.player.inventory.menu.MenuInventoryCreative.creativeItemsCount;

@Mixin(MenuInventoryCreative.class)
public class MenuInventoryCreativeMixin extends MenuInventory {

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void injected(CallbackInfo ci) {

		List<ItemStack> slabWools = new ArrayList<>();
		List<ItemStack> stairWools = new ArrayList<>();
		List<ItemStack> carpets = new ArrayList<>();

		List<ItemStack> paintedGlasses = new ArrayList<>();

		List<ItemStack> paintedGlassTrapdoors = new ArrayList<>();

		List<ItemStack> paintedGlassDoors = new ArrayList<>();

		for (int i = 0; i < DyeColor.COLOR_AMOUNT; i++) {
			slabWools.add(new ItemStack(JEBBlocks.slabWool, 1, i << 4));
			stairWools.add(new ItemStack(JEBBlocks.stairWool, 1, i << 4));
			carpets.add(new ItemStack(JEBBlocks.carpet, 1, i << 4));

			paintedGlasses.add(new ItemStack(JEBBlocks.glassPainted, 1, i));

			paintedGlassTrapdoors.add(new ItemStack(JEBBlocks.glassTrapdoorPainted, 1, i << 4));

			paintedGlassDoors.add(new ItemStack(JEBItems.glassDoorPainted, 1, i));
		}

		int index1 = -1;
		int index2 = -1;
		int index3 = -1;
		int index4 = -1;
		for (int i = 0; i < creativeItems.size(); i++) {
			if (creativeItems.get(i).itemID == Blocks.WOOL.id()) {
				index1 = i;
			} else if (creativeItems.get(i).itemID == Blocks.GLASS.id()) {
				index2 = i;
			} else if (creativeItems.get(i).itemID == Blocks.TRAPDOOR_GLASS.id()) {
				index3 = i;
			} else if (creativeItems.get(i).itemID == Items.DOOR_GLASS.id) {
				index4 = i;
			}
		}

		List<ItemStack> sectionBeforeAll = new ArrayList<>(creativeItems.subList(0, index1 + 1));
		List<ItemStack> section2 = new ArrayList<>(creativeItems.subList(index1 + 1, index2 + 1));
		List<ItemStack> section3 = new ArrayList<>(creativeItems.subList(index2 + 1, index3 + 1));
		List<ItemStack> section4 = new ArrayList<>(creativeItems.subList(index3 + 1, index4 + 1));
		List<ItemStack> sectionAfterAll = new ArrayList<>(creativeItems.subList(index4 + 1, creativeItems.size()));

		creativeItems = new ArrayList<>();
		creativeItems.addAll(sectionBeforeAll);
		creativeItems.addAll(slabWools);
		creativeItems.addAll(stairWools);
		creativeItems.addAll(carpets);
		creativeItems.addAll(section2);
		creativeItems.addAll(paintedGlasses);
		creativeItems.addAll(section3);
		creativeItems.addAll(paintedGlassTrapdoors);
		creativeItems.addAll(section4);
		creativeItems.addAll(paintedGlassDoors);
		creativeItems.addAll(sectionAfterAll);
		creativeItemsCount  = creativeItems.size();

	}

	public MenuInventoryCreativeMixin(ContainerInventory inventory) {
		super(inventory);
	}

}
