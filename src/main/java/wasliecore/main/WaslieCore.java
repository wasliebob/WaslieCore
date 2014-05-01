package wasliecore.main;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import wasliecore.handlers.commands.CommandWSC;
import wasliecore.handlers.events.OnPreRenderEvent;
import wasliecore.helpers.FileHelper;
import wasliecore.helpers.RewardHelper;
import wasliecore.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = WaslieCore.modName, name = WaslieCore.modName, version = "1.0")
public class WaslieCore {
    @SidedProxy(clientSide = "wasliecore.proxies.ClientProxy", serverSide = "wasliecore.proxies.CommonProxy")
    public static CommonProxy proxy;

    @Instance("WaslieCore")
    public static WaslieCore instance;
    public static final double version = 1.09;
    public static final String modName = "WaslieCore";
    public static final String alias = "WsC";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	proxy.init();
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
    	if((Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment")){
    		System.out.println("WaslieCore is running in a dev envoirment, ignoring all events");
    	}else{
    		if(evt.getSide() == Side.CLIENT){
    			MinecraftForge.EVENT_BUS.register(new OnPreRenderEvent());}
    	}
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
    	if(MinecraftServer.getServer() != null){
             MinecraftServer server = MinecraftServer.getServer();
             ICommandManager command = server.getCommandManager();
             ServerCommandManager manager = (ServerCommandManager) command;
             manager.registerCommand(new CommandWSC());
    	}
    }
}