package wasliecore.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemHelper {
	public static boolean canHarvest(Block block, ItemStack stack){
		return ((ItemTool)stack.getItem()).canHarvestBlock(block, stack);
	}
}