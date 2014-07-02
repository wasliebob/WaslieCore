package wasliecore.helpers;

import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
	public static NBTTagCompound createTagCompound(){
		NBTTagCompound tag = new NBTTagCompound();
		return tag;
	}
}