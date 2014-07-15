package wasliecore.misc.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import wasliecore.helpers.Utils;
import wasliecore.interfaces.IWrench;
import wasliecore.main.WaslieCore;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemWE extends Item implements IWrench{

	public ItemWE() {
		setMaxStackSize(1);
		setUnlocalizedName(WaslieCore.modName.toLowerCase() + "." + "item" + "." + "worldEdit");
		setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}

	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(WaslieCore.modName.toLowerCase() + ":" + "worldedit");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote && !player.isSneaking()){
			int x = Utils.getTargetX(player);
			int y = Utils.getTargetY(player);
			int z = Utils.getTargetZ(player);
			
			if(Utils.hasCompound(stack)){
					stack.getTagCompound().setInteger("sX", x);
					stack.getTagCompound().setInteger("sY", y);
					stack.getTagCompound().setInteger("sZ", z);
					
					doWorldEdit(world, stack);
					player.addChatComponentMessage(new ChatComponentText("Executed World Edit"));
			}
		}else if(!world.isRemote && player.isSneaking()){
			if(Utils.hasCompound(stack)){
				Block b = Utils.getTargetBlock(player);
				int meta = Utils.getTargetBlockMeta(player);
				if(b != null && b != Blocks.air){
					stack.getTagCompound().setString("block", getName(b));
					stack.getTagCompound().setInteger("meta", meta);
				}
			}
		}
		return stack;
    }	
	public void doWorldEdit(World world, ItemStack stack){
		if(Utils.hasCompound(stack)){
			int sX = stack.getTagCompound().getInteger("sX");
			int sY = stack.getTagCompound().getInteger("sY");
			int sZ = stack.getTagCompound().getInteger("sZ");

			if(stack.getTagCompound().getString("block") != null){
				Block b = Block.getBlockFromName(stack.getTagCompound().getString("block"));
				int meta = stack.getTagCompound().getInteger("meta");
				if(b != null && b != Blocks.air){
					world.setBlock(sX, sY, sZ, b);
					
					world.setBlock(sX + 1, sY, sZ, b);
					world.setBlock(sX - 1, sY, sZ, b);
		
					world.setBlock(sX, sY, sZ + 1, b);
					world.setBlock(sX, sY, sZ - 1, b);
		
					world.setBlock(sX + 1, sY, sZ + 1, b);
					world.setBlock(sX - 1, sY, sZ + 1, b);
					world.setBlock(sX + 1, sY, sZ - 1, b);
					world.setBlock(sX - 1, sY, sZ - 1, b);
					
					/** Meta */
					world.setBlockMetadataWithNotify(sX, sY, sZ, meta, 2);
					
					world.setBlockMetadataWithNotify(sX + 1, sY, sZ, meta, 2);
					world.setBlockMetadataWithNotify(sX - 1, sY, sZ, meta, 2);

					world.setBlockMetadataWithNotify(sX, sY, sZ + 1, meta, 2);
					world.setBlockMetadataWithNotify(sX, sY, sZ - 1, meta, 2);

					world.setBlockMetadataWithNotify(sX + 1, sY, sZ + 1, meta, 2);
					world.setBlockMetadataWithNotify(sX - 1, sY, sZ + 1, meta, 2);
					world.setBlockMetadataWithNotify(sX + 1, sY, sZ - 1, meta, 2);
					world.setBlockMetadataWithNotify(sX - 1, sY, sZ - 1, meta, 2);

				}
			}
		}
	}
	
	public String getName(Block b){
		return GameData.getBlockRegistry().getNameForObject(b);
	}
	
	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
    	super.onUpdate(stack, world, entity, par4, par5);
		if(!stack.hasTagCompound())
    		stack.setTagCompound(new NBTTagCompound());
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player){
    	super.onCreated(stack, world, player);
    	if(!stack.hasTagCompound())
    		stack.setTagCompound(new NBTTagCompound());
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().getString("block") != null)
				list.add("Block: " + Block.getBlockFromName(stack.getTagCompound().getString("block")).getLocalizedName());
			
			list.add("Meta: " + stack.getTagCompound().getInteger("meta"));
			
//			if(stack.getTagCompound().getString("mode") != null)
//				list.add("Mode: " + stack.getTagCompound().getString("mode"));
		}
	}
}