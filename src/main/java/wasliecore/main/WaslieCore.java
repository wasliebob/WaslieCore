package wasliecore.main;

import net.minecraft.launchwrapper.Launch;
import net.minecraft.nbt.NBTTagCompound;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import wasliecore.handlers.commands.CommandWSC;
import wasliecore.helpers.FileHelper;
import wasliecore.helpers.IMCHelper;
import wasliecore.helpers.NBTHelper;
import wasliecore.helpers.RewardHelper;
import wasliecore.misc.MiscRegister;
import wasliecore.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = WaslieCore.modName, name = WaslieCore.modName, version = "1.1")
public class WaslieCore {
    @SidedProxy(clientSide = "wasliecore.proxies.ClientProxy", serverSide = "wasliecore.proxies.CommonProxy")
    public static CommonProxy proxy;

    @Instance("WaslieCore")
    public static WaslieCore instance;
    public static final double version = 1.1;
    public static final String modName = "WaslieCore";
    public static final String alias = "WsC";
    public static String configLocation;
    public static MiscRegister register_misc = new MiscRegister();
	public static final Logger logger = LogManager.getLogger(WaslieCore.modName);
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	proxy.init();
		@SuppressWarnings("unused")
		Config config = new Config();
		Config.loadConfig(event);
		configLocation = event.getModConfigurationDirectory().toString();
		
		RewardHelper.initRewards();
    	FileHelper.createMainFolder();
    	FileHelper.addDonators();

    	register_misc.preInit();
    	
    	System.out.println("WaslieCore is brought to you by wasliebob");
    	
    	NBTTagCompound tag = NBTHelper.createTagCompound();
    	tag.setBoolean(IMCHelper.author_wasliebob, true);
    	tag.setBoolean(IMCHelper.mod_wasliecore, true);

    	FMLInterModComms.sendMessage("WaslieCore", IMCHelper.message_register, tag);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){}
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
    	if((Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment")){
    		System.out.println("WaslieCore is running in a dev envoirment, ignoring all events");
    	}else{
//    		if(evt.getSide() == Side.CLIENT){
//    			MinecraftForge.EVENT_BUS.register(new OnPreRenderEvent());}
    	}
    }
    
    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
    	if((Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment")){
    		System.out.println("WaslieCore is running in a dev envoirment, ignoring all events");
    	}else{
    		event.registerServerCommand(new CommandWSC());
    	}
    }
    
	@EventHandler
	public void imcCallback(FMLInterModComms.IMCEvent e){
		for (final FMLInterModComms.IMCMessage m : e.getMessages()){
			if (m.key.equalsIgnoreCase(IMCHelper.message_register)){
				if(m.isNBTMessage()){
					IMCHelper.handleIMCStuff(m);
				}
			}
		}
	}
}