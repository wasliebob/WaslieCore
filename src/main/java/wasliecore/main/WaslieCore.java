package wasliecore.main;

import net.minecraftforge.common.MinecraftForge;
import wasliecore.handlers.events.OnPlayerJoinEvent;
import wasliecore.handlers.events.OnPreRenderEvent;
import wasliecore.helpers.FileHelper;
import wasliecore.helpers.RewardHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = WaslieCore.modName, name = WaslieCore.modName, version = "1.0")
public class WaslieCore {
    @Instance("WaslieCore")
    public static WaslieCore instance;
    public static final double version = 1.06;
    public static final String modName = "WaslieCore";
    public static final String alias = "WsC";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
		@SuppressWarnings("unused")
		Config config = new Config();
		Config.loadConfig(event);
		
		RewardHelper.initRewards();
    	FileHelper.createMainFolder();
    	FileHelper.addDonators();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){}
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
    	if(evt.getSide() == Side.CLIENT){
    		MinecraftForge.EVENT_BUS.register(new OnPreRenderEvent());
    		MinecraftForge.EVENT_BUS.register(new OnPlayerJoinEvent());}
    }
}