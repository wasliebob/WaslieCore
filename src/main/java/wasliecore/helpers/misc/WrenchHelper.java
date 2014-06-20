package wasliecore.helpers.misc;

import java.util.HashMap;

import net.minecraft.block.Block;

public class WrenchHelper {
	public static void addWrenchable(Block block, int wrenchTier){
		wrenchable.put(block, wrenchTier);
	}
	
	public static boolean isWrenchable(Block block, int wrenchTier){
		return wrenchable.containsKey(block) && wrenchTier <= wrenchable.get(block);
	}
	
	public static int getRequiredTier(Block block){
		return wrenchable.get(block);
	}
	
	public static HashMap<Block, Integer> wrenchable = new HashMap<Block, Integer>();
}