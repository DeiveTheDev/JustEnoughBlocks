package deivethedev.jeb;

import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
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

		cobbleBasaltMossy = cobbleBuilder.build("cobble.basalt.mossy", "cobble_basalt_mossy", nextID(), b -> new BlockLogicCobble(b, Material.basalt, () -> Blocks.GRAVEL));

		cobbleGraniteMossy = cobbleBuilder.build("cobble.granite.mossy", "cobble_granite_mossy", nextID(), b -> new BlockLogicCobble(b, Material.granite, () -> Blocks.GRAVEL));

		cobbleLimestoneMossy = cobbleBuilder.build("cobble.limestone.mossy", "cobble_limestone_mossy", nextID(), b -> new BlockLogicCobble(b, Material.limestone, () -> Blocks.GRAVEL));

		slateCarved = carvedBuilder.build("slate.carved", "slate_carved", nextID(), b -> new BlockLogic(b, Material.slate));

		slabSlatePolished = stoneBuilder.build("slab.slate.carved", "slab_slate_carved", nextID(), b -> new BlockLogicSlab(b, slateCarved));

		LOGGER.info("Blocks initialized.");
	}
}
