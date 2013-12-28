package noahp78.mods.wdid;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.Player;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiHelper extends GuiScreen {
	public GuiHelper(EntityPlayer player)
	{

	}
	public final int xSizeOfTexture = 176;
	public final int ySizeOfTexture = 88;
	@Override
	public void drawScreen(int x, int y, float f)
	{
	drawDefaultBackground();

	TextureObject var4 = this.mc.renderEngine.getTexture(new ResourceLocation("wdid", "gui/GuiTexture.png"));
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.renderEngine.bindTexture(new ResourceLocation("wdid", "gui/GuiTexture.png"));

	int posX = (this.width - xSizeOfTexture) / 2;
	int posY = (this.height - ySizeOfTexture) / 2;

	drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

	super.drawScreen(x, y, f);
	}
	public void initGui()
	{

	int posX = (this.width - xSizeOfTexture) / 2;
	int posY = (this.height - ySizeOfTexture) / 2;

	//this.controlList.add(new GuiButton(0, posX+ 40, posY + 40, 100, 20, "no use"));
	fontRenderer.drawString(noahp78.mods.wdid.wdid.GetInfo(net.minecraft.block.Block.anvil), posX, posY, 4210752);
	}

}
