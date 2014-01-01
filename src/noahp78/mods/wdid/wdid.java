package noahp78.mods.wdid;

import java.util.EnumSet;
import java.util.Hashtable;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import noahp78.mods.noahsmod.helpers.LogHelper;
import noahp78.mods.wdid.client.GameOverlay;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
@Mod(modid="wdid", name="What Does It Do Mod", version="0.0.1-Development Build")
@NetworkMod(clientSideRequired=true)


public class wdid {
	 private static Hashtable<Block, String> mapBlocksInfo = new Hashtable<Block, String>();
	 @Instance(value = "wdid")

     public static wdid instance;
     
     // Says where the client and server 'proxy' code is loaded.
     //@SidedProxy(clientSide="noahp78.mods.noahsmod.client.ClientProxy", serverSide="noahp78.mods.noahsmod.CommonProxy")
	 
	    
	    // Proxy's are broken!
	 //Says where the client and server 'proxy' code is loaded.
	   //@SidedProxy(clientSide="tutorial.generic.client.ClientProxy", serverSide="tutorial.generic.CommonProxy")
	    public static CommonProxy proxy;
	    
	    @EventHandler // used in 1.6.2
	    //@PreInit    // used in 1.5.2
	    public void preInit(FMLPreInitializationEvent event) {
	    
	            // Stub Method = new Hashtable<Block, String>();
	    System.out.println("PRE-INIT event for What Does it DO");
	    RegisterBlockInfo(net.minecraft.block.Block.stone, "Basic Building Material");
	    System.out.println(GetInfo(net.minecraft.block.Block.stone));
	    noahp78.mods.wdid.modhelpers.minecraft.init();
	    
	    
	    }
	    
	    @EventHandler // used in 1.6.2
	    //@Init       // used in 1.5.2
	    public void load(FMLInitializationEvent event) {
	    	KeyBinding[] key = {new KeyBinding("WDID Help Key", Keyboard.KEY_H)};
	         boolean[] repeat = {false};
	         KeyBindingRegistry.registerKeyBinding(new Keybinder(key, repeat));
	    	//proxy.registerRenderers();
	         TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
	         TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.CLIENT);
	         
	    }
	    
	    @EventHandler // used in 1.6.2
	    //@PostInit   // used in 1.5.2
	    public void postInit(FMLPostInitializationEvent event) {
	            // Stub Method
	    	System.out.println("Enabling Mods!");
	    	
	    	//IC2 Init
	        if (Loader.isModLoaded("IC2")) {
	            try {
	                       //do stuff
	            	noahp78.mods.wdid.modhelpers.IC2.InitIC2();

	                System.out.println("[wdid] found IC2 = ModInfo Loading");
	            }
	            catch (Exception e) {
	                System.out.println( "[wdid] IC2 Module cant be loaded");
	                e.printStackTrace(System.err);
	            }
	        }
	        if (!(Loader.isModLoaded("IC2"))){
	        	System.out.println("[wdid] IC2 is not found, not loading IC2 compability");
	        	
	        }
	        
	    	//MinecraftForge.EVENT_BUS.register(new GuiBuffBar(Minecraft.getMinecraft()));
	    	MinecraftForge.EVENT_BUS.register(new GameOverlay(Minecraft.getMinecraft()));
	    }
	    public static void RegisterBlockInfo(Block Block, String Info){
	    	mapBlocksInfo.put(Block, Info);
	    	
	    }
	    public static String GetInfo(Block Block){
	    	return mapBlocksInfo.get(Block);
	    	
	    }

}
