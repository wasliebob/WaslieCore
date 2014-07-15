package wasliecore.misc.infopackets;

import net.minecraft.block.Block;

public class TargetInformation {
	public TargetInformation(Block block, int meta, int x, int y, int z){
		this.block = block;
		this.meta = meta;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Block block;
	public int meta;
	public int x;
	public int y;
	public int z;
}