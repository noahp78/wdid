package noahp78.mods.wdid.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

	//
	// GuiBuffBar implements a simple status bar at the top of the screen which 
	// shows the current buffs/debuffs applied to the character.
	//
	public class GameOverlay extends Gui
	{
	  private Minecraft mc;

	  public GameOverlay(Minecraft mc)
	  {
	    super();
	    
	    // We need this to invoke the render engine.
	    this.mc = mc;
	  }

	  private static final int BUFF_ICON_SIZE = 18;
	  private static final int BUFF_ICON_SPACING = BUFF_ICON_SIZE + 2; // 2 pixels between buff icons
	  private static final int BUFF_ICON_BASE_U_OFFSET = 0;
	  private static final int BUFF_ICON_BASE_V_OFFSET = 198;
	  private static final int BUFF_ICONS_PER_ROW = 8;
	  private static int blockHitX;
	  private static int blockHitY;
	  private static int blockHitZ;
	  
	  //
	  // This event is called by GuiIngameForge during each frame by
	  // GuiIngameForge.pre() and GuiIngameForce.post().
	  //
	  @ForgeSubscribe(priority = EventPriority.NORMAL)
	  public void onRenderExperienceBar(RenderGameOverlayEvent event)
	  {
	    // 
	    // We draw after the ExperienceBar has drawn.  The event raised by GuiIngameForge.pre()
	    // will return true from isCancelable.  If you call event.setCanceled(true) in
	    // that case, the portion of rendering which this event represents will be canceled.
	    // We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
	    // false and that the eventType represents the ExperienceBar event.
	    if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
	    {      
	      return;
	    }
// Do our code, see where the player is looking at
	    if((mc.renderViewEntity.rayTrace(200, 1.0F) != null)){
	       blockHitX = mc.renderViewEntity.rayTrace(200, 1.0F).blockX;
	         blockHitY = mc.renderViewEntity.rayTrace(200, 1.0F).blockY;
	         blockHitZ = mc.renderViewEntity.rayTrace(200, 1.0F).blockZ;
	        int blockHitSide = mc.renderViewEntity.rayTrace(200, 1.0F).sideHit;
	    }
	    // Starting position for the buff bar - 2 pixels from the top left corner.
	    	
	    int xPos = 2;
	    int yPos = 2;
	    Collection collection = this.mc.thePlayer.getActivePotionEffects();
	    
	      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	      GL11.glDisable(GL11.GL_LIGHTING);      
	      this.mc.renderEngine.bindTexture(new ResourceLocation ("/gui/inventory.png"));      

	    //  for (Iterator iterator = this.mc.thePlayer.getActivePotionEffects()
	     //     .iterator(); iterator.hasNext(); xPos += BUFF_ICON_SPACING)
	      //{
	        //PotionEffect potioneffect = (PotionEffect) iterator.next();
	        //Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
	        

	       /* if (potion.hasStatusIcon())
	        {
	         /* int iconIndex = potion.getStatusIconIndex();
	          this.drawTexturedModalRect(
	              xPos, yPos, 
	              BUFF_ICON_BASE_U_OFFSET + iconIndex % BUFF_ICONS_PER_ROW * BUFF_ICON_SIZE, BUFF_ICON_BASE_V_OFFSET + iconIndex / BUFF_ICONS_PER_ROW * BUFF_ICON_SIZE,
	              BUFF_ICON_SIZE, BUFF_ICON_SIZE);
	        }  */
	        
	     // setup render
	      if(Keyboard.isKeyDown(Keyboard.KEY_H)){
	        ScaledResolution res = new ScaledResolution(this.mc.gameSettings,
	        this.mc.displayWidth, this.mc.displayHeight);
	        FontRenderer fontRender = mc.fontRenderer;
	        int width = res.getScaledWidth();
	        int height = res.getScaledHeight();
	        mc.entityRenderer.setupOverlayRendering();

	        // draw
	        if (Block.blocksList[this.mc.thePlayer.worldObj.getBlockId(blockHitX, blockHitY, blockHitZ)] != null){
	        	String text = "Hello World";
		        int x = 2;
		        int y = 2;
		        int color = 0xFFFFFF;
		        if (noahp78.mods.wdid.wdid.GetInfo(Block.blocksList[this.mc.thePlayer.worldObj.getBlockId(blockHitX, blockHitY, blockHitZ)]) != null){
		        for (String part : getParts(noahp78.mods.wdid.wdid.GetInfo(Block.blocksList[this.mc.thePlayer.worldObj.getBlockId(blockHitX, blockHitY, blockHitZ)]), 84)){
		        	if (part !=null){
		        		fontRender.drawStringWithShadow(part, x,y, color);
			        	y=(y+10);
		        	}
		        }
		        	
		        	
		        	
		        }
	        	
	        }
	        
	        /*
	        String text = "Hello World";
	        int x = 2;
	        int y = 2;
	        int color = 0xFFFFFF;
	        fontRender.drawStringWithShadow(noahp78.mods.wdid.wdid.GetInfo(Block.blocksList[this.mc.thePlayer.worldObj.getBlockId(blockHitX, blockHitY, blockHitZ)]), x, y, color);
	  */
	  }
	  }
	  private static List<String> getParts(String string, int partitionSize) {
	        List<String> parts = new ArrayList<String>();
	        int len = string.length();
	        for (int i=0; i<len; i+=partitionSize)
	        {
	            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
	        }
	        return parts;
	    }
	  }
