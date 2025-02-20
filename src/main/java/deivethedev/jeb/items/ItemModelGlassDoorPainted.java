package deivethedev.jeb.items;

import net.minecraft.client.render.item.model.ItemModelDoorPainted;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDoorPainted;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;

public class ItemModelGlassDoorPainted extends ItemModelStandard {
	public static IconCoordinate[] doorIcons = new IconCoordinate[16];

	public ItemModelGlassDoorPainted(Item item) {
		super(item, (String)null);
	}

	public @NotNull IconCoordinate getIcon(Entity entity, ItemStack itemStack) {
		int meta = itemStack.getMetadata();
		return doorIcons[meta & 15];
	}

	static {
		for(DyeColor c : DyeColor.itemOrderedColors()) {
			doorIcons[c.itemMeta] = TextureRegistry.getTexture("jeb:item/door_glass_" + c.colorID);
		}

	}
}
