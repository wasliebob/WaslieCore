package wasliecore.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MaterialHelper {
	public static ItemStack createStack(Item item){
		return new ItemStack(item);
	}
	
	public static ItemStack createStack(Block block){
		return new ItemStack(block);
	}
	
	public static int getMeta(ItemStack stack){
		return stack.getItemDamage();
	}
	
	public static String getName(Item item){
		return item.getUnlocalizedName();
	}
	
	public static String getName(Block block){
		return block.getUnlocalizedName();
	}
	
	public static String getName(ItemStack stack){
		return stack.getUnlocalizedName();
	}
}