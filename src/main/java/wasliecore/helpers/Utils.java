package wasliecore.helpers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Utils {
	/**
	 * Copied from CoFHLib BlockHelper.class (https://github.com/CoFH/CoFHLib/blob/master/src/main/java/cofh/util/BlockHelper.java), with KingLemmings permission!
	 * @author King Lemming
	 */
	public static MovingObjectPosition getMovingObjectPosition(EntityPlayer player){
		Vec3 posVec = Vec3.createVectorHelper(player.posX, player.posY, player.posZ);
		Vec3 lookVec = player.getLook(1);
		posVec.yCoord += player.getEyeHeight();
		lookVec = posVec.addVector(lookVec.xCoord * 4.5F, lookVec.yCoord * 4.5F, lookVec.zCoord * 4.5F);
		return player.worldObj.rayTraceBlocks(posVec, lookVec);
	}
	
	/**
	 * @author wasliebob
	 */
	public static Block getTargetBlock(EntityPlayer player){
		MovingObjectPosition mop = getMovingObjectPosition(player);
		if(mop != null){
			int x = mop.blockX;
			int y = mop.blockY;
			int z = mop.blockZ;
			Block b = player.worldObj.getBlock(x, y, z);
			if(b != null){
				return b;
			}
		}
		return null;
	}
	
	/**
	 * @author wasliebob
	 */
	public static TileEntity getTargetTile(EntityPlayer player){
		MovingObjectPosition mop = getMovingObjectPosition(player);
		if(mop != null){
			int x = mop.blockX;
			int y = mop.blockY;
			int z = mop.blockZ;
			TileEntity t = player.worldObj.getTileEntity(x, y, z);
			if(t != null){
				return t;
			}
		}
		return null;
	}
	
	/**
	 * @author wasliebob
	 */
	public static int getTargetBlockMeta(EntityPlayer player){
		MovingObjectPosition mop = getMovingObjectPosition(player);
		if(mop != null){
			int x = mop.blockX;
			int y = mop.blockY;
			int z = mop.blockZ;
			Block b = player.worldObj.getBlock(x, y, z);
			int meta = player.worldObj.getBlockMetadata(x, y, z);
			if(b != null){
				return meta;
			}
		}
		return 0;
	}
	
	/**
	 * @author wasliebob
	 */
	public static int getTargetX(EntityPlayer player){
		MovingObjectPosition mop = getMovingObjectPosition(player);
		if(mop != null)
			return mop.blockX;
		return 0;
	}
	
	/**
	 * @author wasliebob
	 */
	public static int getTargetY(EntityPlayer player){
		MovingObjectPosition mop = getMovingObjectPosition(player);
		if(mop != null)
			return mop.blockY;
		return 0;
	}
	
	/**
	 * @author wasliebob
	 */
	public static int getTargetZ(EntityPlayer player){
		MovingObjectPosition mop = getMovingObjectPosition(player);
		if(mop != null)
			return mop.blockZ;
		return 0;
	}
	
	/**
	 * @author wasliebob
	 */
    public static void dropBlock(World world, int x, int y, int z, ItemStack stack){
        float f = 0.7F;
        double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, stack);
      
        world.spawnEntityInWorld(entityitem);
    }
    
	/**
	 * @author wasliebob
	 */
    public static void dropContent(World world, int x, int y, int z){
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
                return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
        	ItemStack item = inventory.getStackInSlot(i);

        	if (item != null && item.stackSize > 0) {
        		float rx = rand.nextFloat() * 0.8F + 0.1F;
        		float ry = rand.nextFloat() * 0.8F + 0.1F;
        		float rz = rand.nextFloat() * 0.8F + 0.1F;

        		EntityItem entityItem = new EntityItem(world,
        				x + rx, y + ry, z + rz,
        				new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

        		if (item.hasTagCompound()) {
        			entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
        		}

        		float factor = 0.05F;
        		entityItem.motionX = rand.nextGaussian() * factor;
        		entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
        		entityItem.motionZ = rand.nextGaussian() * factor;
        		world.spawnEntityInWorld(entityItem);
        		item.stackSize = 0;
        	}
        }
    }
    
    /**
     * @author wasliebob
     */
	public static boolean hasCompound(ItemStack stack){
		return stack.hasTagCompound();
	}
	
	/**
	 * @author wasliebob
	 */
	public static Minecraft getMC(){
		return Minecraft.getMinecraft();
	}
}