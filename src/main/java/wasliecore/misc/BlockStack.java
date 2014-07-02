package wasliecore.misc;

import net.minecraft.block.Block;

public class BlockStack {
	public BlockStack(Block block, int meta){
		this.block = block;
		this.meta = meta;
	}
	public Block block;
	public int meta;
}