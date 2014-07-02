package wasliecore.helpers;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.nbt.NBTTagCompound;

public class IMCHelper {
	public static final String message_register = "message_register";
	public static final String author_wasliebob = "author_wasliebob";
	public static final String mod_wasliecore = "mod_wasliecore";
	public static void handleIMCStuff(FMLInterModComms.IMCMessage m){
		NBTTagCompound tag = m.getNBTValue();
		if(tag != null){
			boolean author = tag.getBoolean(IMCHelper.author_wasliebob);
			boolean mod = tag.getBoolean(IMCHelper.mod_wasliecore);
			
			if(author == true)
				ModHelper.createdByWasliebob.add(m.getSender());
			if(mod == true)
				ModHelper.usingWsC.add(m.getSender());
		}
	}
}