package wasliecore.helpers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
	public static NBTTagCompound createTagCompound(){
		NBTTagCompound tag = new NBTTagCompound();
		return tag;
	}
	
	public static void setTag(ItemStack stack, NBTTagCompound tag, boolean force){
		if(force){
			stack.setTagCompound(tag);
		}else{
			if(!NBTHelper.hasTag(stack));
				stack.setTagCompound(tag);
		}
	}
	
	public static boolean hasTag(ItemStack stack){
		return stack.hasTagCompound();
	}
	
	public static NBTTagCompound getTag(ItemStack stack){
		if(NBTHelper.hasTag(stack))
			return stack.getTagCompound();
		return null;
	}
	
	public static void setInt(ItemStack stack, String key, int value){
		if(NBTHelper.hasTag(stack))
			stack.getTagCompound().setInteger(key, value);
	}
	
	public static void setString(ItemStack stack, String key, String value){
		if(NBTHelper.hasTag(stack))
			stack.getTagCompound().setString(key, value);
	}
}