package wasliecore.main;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import wasliecore.handlers.events.OnPlayerJoinEvent;
import wasliecore.helpers.FileHelper;
import wasliecore.helpers.RewardHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "WaslieCore", name = "WaslieCore", version = "1.0")
public class WaslieCore {
    @Instance("WaslieCore")
    public static WaslieCore instance;
    public static String version = "1.0";
    public static String modName = "WaslieCore";
    public static String alias = "WsC";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
		@SuppressWarnings("unused")
		Config config = new Config();
		Config.loadConfig(event);
		
    	FileHelper.createMainFolder();
//    	FileHelper.getDonators();
    	RewardHelper.addRewards(2.50, new ItemStack[]{new ItemStack(Items.apple)});
    	RewardHelper.addRewards(5.00, new ItemStack[]{new ItemStack(Items.diamond_pickaxe)});
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){}
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
    	MinecraftForge.EVENT_BUS.register(new OnPlayerJoinEvent());
    }
}