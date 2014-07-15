package wasliecore.helpers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import wasliecore.misc.infopackets.Coordinates;

public class CoordinateHelper {
	public static Coordinates getPlayerCoordInfo(EntityPlayer player){
		Coordinates coords = new Coordinates((int)player.posX, (int)player.posY, (int)player.posZ);
		return coords;
	}
	
	public static Coordinates getEntityCoordInfo(Entity entity){
		Coordinates coords = new Coordinates((int)entity.posX, (int)entity.posY, (int)entity.posZ);
		return coords;
	}

	public static Coordinates getEntityLivingCoordInfo(EntityLiving living){
		Coordinates coords = new Coordinates((int)living.posX, (int)living.posY, (int)living.posZ);
		return coords;
	}
	
	public static Coordinates createCoordInfo(int x, int y, int z){
		Coordinates coords = new Coordinates(x, y, z);
		return coords;
	}
}