package wasliecore.helpers;

import net.minecraft.block.Block;

public class BlockHelper {
	public static int getBlockHarvestLevel(Block block, int meta){
		int harvestLevel = block.getHarvestLevel(meta);
		return harvestLevel;
	}
}