package wasliecore.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import wasliecore.misc.infopackets.MaterialStack;

public class PlayerHelper {
	public static MaterialStack getBlockStackViewing(World world){
		Minecraft mc = Utils.getMC();
		MovingObjectPosition mop = mc.objectMouseOver;
		if(mop != null){
			int x = mop.blockX;
			int y = mop.blockY;
			int z = mop.blockZ;
			Block b = world.getBlock(x, y, z);
			int meta = world.getBlockMetadata(x, y, z);
			if(b != null){
				return new MaterialStack(b, meta);
			}
		}
		return null;
	}
	
	public static Entity getEntityViewing(World world){
		Minecraft mc = Utils.getMC();
		MovingObjectPosition mop = mc.objectMouseOver;
		if(mop != null && mop.entityHit != null){
			return mop.entityHit;
		}
		return null;
	}
	
	public static double getDistance(EntityPlayer player, int x, int y, int z){
		return player.getDistanceSq(x, y, z);
	}
	
	public static double getDistanceToEntity(EntityPlayer player, Entity entity){
		return player.getDistanceSqToEntity(entity);
	}
	
	public static AxisAlignedBB getBoundBox(EntityPlayer player){
		return player.boundingBox;
	}
	
	public static void sendMessage(EntityPlayer player, String message){
		player.addChatMessage(new ChatComponentText(message));
	}
}