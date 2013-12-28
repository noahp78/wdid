package noahp78.mods.wdid;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class Keybinder extends KeyHandler
{
	public static boolean keyPressed = false;
	public static boolean keyHasBeenPressed = false;
	
    private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
   
    public Keybinder(KeyBinding[] keyBindings, boolean[] repeatings)
    {
            super(keyBindings, repeatings);
    }
    @Override
    public String getLabel()
    {
            return "What Does It Do?";
    }
    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
    {
    keyHasBeenPressed = true;
    }
    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
    {
    if (keyPressed) {
    keyHasBeenPressed = false;
    keyPressed = true; 
    }
    
    }
    @Override
    public EnumSet<TickType> ticks()
    {
            return tickTypes;
    }
} 

