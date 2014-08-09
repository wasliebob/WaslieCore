package wasliecore.helpers;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockHelper {
	public static int getBlockHarvestLevel(Block block, int meta){
		int harvestLevel = block.getHarvestLevel(meta);
		return harvestLevel;
	}
	
	public static int getBlockColor(Block block){
		return block.getBlockColor();
	}
	
	public static int getDamageValue(Block block, World world, int x, int y, int z){
		return block.getDamageValue(world, x, y, z);
	}
}