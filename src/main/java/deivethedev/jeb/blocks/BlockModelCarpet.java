package deivethedev.jeb.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelWool;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;



@Environment(EnvType.CLIENT)
public class BlockModelCarpet<T extends BlockLogic> extends BlockModelWool<T> {

	public BlockModelCarpet(Block<T> block) {
		super(block);
		this.withCustomItemBounds((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)0.0625F, (double)1.0F);
	}

	public void renderBlockOnInventory(Tessellator tessellator, int metadata, float brightness, float alpha, @Nullable Integer lightmapCoordinate) {
		GL11.glTranslatef(0.0F, 0.3F, 0.0F);
		super.renderBlockOnInventory(tessellator, metadata, brightness, alpha, lightmapCoordinate);
	}

	@Override
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
		meta >>= 4;
		return BlockModelWool.texCoords[meta & 15];
	}

}
