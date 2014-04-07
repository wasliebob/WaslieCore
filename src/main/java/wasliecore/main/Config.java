package wasliecore.main;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
    	mapLocation = config.get(Configuration.CATEGORY_GENERAL, "fileLocation", e.getModConfigurationDirectory().toString()).getString();

		config.save();
	}
	public static String mapLocation;
}
