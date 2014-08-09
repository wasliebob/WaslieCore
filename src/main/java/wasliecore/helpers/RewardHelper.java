package wasliecore.helpers;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RewardHelper {
	public static void initRewards(){
		if(OreDictionary.getOres("ingotDraconic").size() > 0)
			RewardHelper.addRewards(2.50, new ItemStack[]{new ItemStack(OreDictionary.getOres("ingotDraconic").get(0).getItem(), 16)});
	}
	
	public static ItemStack[] getReward(double amount){
		if(amount != 0){
			if(rewards.containsKey(amount)){
				return rewards.get(amount);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static void addRewards(double amount, ItemStack[] rewards){
		RewardHelper.rewards.put(amount, rewards);
	}
	
	public static HashMap<Double, ItemStack[]> rewards = new HashMap<Double, ItemStack[]>();
}