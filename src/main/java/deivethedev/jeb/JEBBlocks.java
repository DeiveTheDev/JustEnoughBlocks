package deivethedev.jeb;

import deivethedev.jeb.blocks.*;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static deivethedev.jeb.JEBMain.LOGGER;
import static deivethedev.jeb.JEBMain.MOD_ID;

public class JEBBlocks {

	// Importing the starting id that we set in TestConfig
	private static int startingID = JEBConfig.CFG.getInt("IDs.startingBlockID");
	private static int nextID() {return startingID++;}

	// Declaring blocks
	public static Block<?> cobbleBasaltMossy;
	public static Block<?> cobbleGraniteMossy;
	public static Block<?> cobbleLimestoneMossy;

	public static Block<?> slateCarved;
	public static Block<BlockLogicSlab> slabSlatePolished;

	public static Block<BlockLogicSlab> slabWool;
	public static Block<BlockLogicStairs> stairWool;
	public static Block<BlockLogicCustomLayerBase> carpet;

	public static Block<?> glassPainted;
	public static Block<BlockLogicDoor> glassDoorPaintedTop;
	public static Block<BlockLogicDoor> glassDoorPaintedBottom;
	public static Block<BlockLogicTrapDoor> glassTrapdoorPainted;

	public static void initBlocks() {

		BlockBuilder stoneBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.STONE)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder carvedBuilder = stoneBuilder.clone()
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU);

		BlockBuilder cobbleBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.STONE)
			.setHardness(2.0f)
			.setResistance(10.0f)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder woolBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.CLOTH)
			.setBlockItem((b) -> new ItemBlockPainted<>(b, true))
			.setHardness(0.8f)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.NOT_IN_CREATIVE_MENU);

		BlockBuilder glassBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GLASS)
			.setHardness(0.3F)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setLightOpacity(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.EXTENDS_MOTION_SENSOR_RANGE, BlockTags.NOT_IN_CREATIVE_MENU);

		BlockBuilder carpetBuilder = woolBuilder.clone();
		carpetBuilder.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_SHEARS, BlockTags.OVERRIDE_STEPSOUND);

		BlockBuilder glassPropsBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GLASS)
			.setHardness(0.3F)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setLightOpacity(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.NOT_IN_CREATIVE_MENU);

		cobbleBasaltMossy = cobbleBuilder.build("cobble.basalt.mossy", "cobble_basalt_mossy", nextID(), b -> new BlockLogicCobble(b, Material.basalt, () -> Blocks.GRAVEL));

		cobbleGraniteMossy = cobbleBuilder.build("cobble.granite.mossy", "cobble_granite_mossy", nextID(), b -> new BlockLogicCobble(b, Material.granite, () -> Blocks.GRAVEL));

		cobbleLimestoneMossy = cobbleBuilder.build("cobble.limestone.mossy", "cobble_limestone_mossy", nextID(), b -> new BlockLogicCobble(b, Material.limestone, () -> Blocks.GRAVEL));

		slateCarved = carvedBuilder.build("slate.carved", "slate_carved", nextID(), b -> new BlockLogic(b, Material.slate));

		slabSlatePolished = stoneBuilder.build("slab.slate.carved", "slab_slate_carved", nextID(), b -> new BlockLogicSlab(b, slateCarved));

		slabWool = woolBuilder.build("slab.wool", "slab_wool", nextID(), b -> new BlockLogicSlabPainted(b, Blocks.WOOL));

		stairWool = woolBuilder.build("stairs.wool", "stairs_wool", nextID(), b -> new BlockLogicStairsPainted(b, Blocks.WOOL));

		carpet = woolBuilder.build("carpet", "carpet", nextID(), b -> new BlockLogicCarpet(b, 0.0625, null, Material.cloth));

		glassPainted = glassBuilder.build("glass.painted", "glass_painted", nextID(), b -> new BlockLogicGlassPainted(b, Material.glass));

		glassDoorPaintedTop = glassPropsBuilder.build("door.glass.painted.top", "glass_door_painted_top", nextID(), b -> new BlockLogicGlassDoorPainted(b, Material.glass, true));

		glassDoorPaintedBottom = glassPropsBuilder.build("door.glass.painted.bottom", "glass_door_painted_bottom", nextID(), b -> new BlockLogicGlassDoorPainted(b, Material.glass, false));

		glassTrapdoorPainted = glassPropsBuilder.build("glass.trapdoor.painted", "glass_trapdoor_painted", nextID(), b -> new BlockLogicGlassTrapdoorPainted(b, Material.glass));

		LOGGER.info("Blocks initialized.");
	}
}
