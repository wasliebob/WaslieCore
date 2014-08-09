package wasliecore.helpers;

import net.minecraft.util.StatCollector;

public class LocalizationHelper {
	public static String localize(String name, int line){
		return StatCollector.translateToLocal(name + "." + line);
	}
}