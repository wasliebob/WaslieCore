package wasliecore.misc.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import wasliecore.main.WaslieCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSwordCheat extends ItemSword{

	public ItemSwordCheat() {
		super(EnumHelper.addToolMaterial("CHEAT", 4, -1, 10F, 0, 0));
		setMaxStackSize(1);
		setUnlocalizedName(WaslieCore.modName.toLowerCase() + "." + "item" + "." + "cheat sword");
		setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(this, this.getUnlocalizedName());
		setMaxDamage(-1);
	}
	
	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(WaslieCore.modName.toLowerCase() + ":" + "sword_cheat");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i){
		list.add(EnumChatFormatting.GREEN + "Insta-Dead");
		list.add(EnumChatFormatting.RED + "Creative Only");
	}
}