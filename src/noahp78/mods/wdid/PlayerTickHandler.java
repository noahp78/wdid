package noahp78.mods.wdid;
import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
public class PlayerTickHandler implements ITickHandler
{
private final EnumSet<TickType> ticksToGet;

/*
         * This Tick Handler will fire for whatever TickType's you construct and register it with.
         */
public PlayerTickHandler(EnumSet<TickType> ticksToGet)
{
         this.ticksToGet = ticksToGet;
}
/*
         * I suggest putting all your tick Logic in EITHER of these, but staying in one
         */
@Override
public void tickStart(EnumSet<TickType> type, Object... tickData)
{
         playerTick((EntityPlayer)tickData[0]);
}
@Override
public void tickEnd(EnumSet<TickType> type, Object... tickData)
{
}
@Override
public EnumSet<TickType> ticks()
{
         return ticksToGet;
}
@Override
public String getLabel()
{
         return "TickPlayer";
}

public static void playerTick(EntityPlayer player)
{
/*	if(Keyboard.isKeyDown(Keyboard.KEY_H))
	{
	//stuff
		System.out.println("key pressed!");
		
		player.openGui(wdid.instance, 0, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	} 
         if(Keybinder.keyPressed)
        	 Keybinder.keyPressed = false;
         {
//Code for when the key is pressed. Notice how you have the player parameter
        	 player.openGui(wdid.instance, 0, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
         }
}
*/
}
}

