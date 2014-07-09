package wasliecore.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MaterialStack {
	public MaterialStack(Item item, int meta){
		this.item = item;
		this.meta = meta;
	}
	
	public MaterialStack(Block block, int meta){
		this.item = Item.getItemFromBlock(block);
		this.meta = meta;
	}
	public Item item;
	public int meta;
}