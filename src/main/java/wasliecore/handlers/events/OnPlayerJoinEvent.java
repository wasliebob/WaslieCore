package wasliecore.handlers.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import wasliecore.helpers.FileHelper;
import wasliecore.helpers.RewardHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OnPlayerJoinEvent {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public void joinEvent(EntityJoinWorldEvent e)
    {
			if(e.entity instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)e.entity;
				if(player.getDisplayName() != null){
					if(FileHelper.isDonator(player.getDisplayName())){
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[WaslieCore] " + EnumChatFormatting.GRAY + "Thank you for donating, it is helping me a lot."));
					
						if(player.getEntityData().getBoolean("WsC_Donator") == false){				
							for(ItemStack stack : RewardHelper.getReward(FileHelper.getAmount(player.getDisplayName()))){
								player.inventory.addItemStackToInventory(stack);
							}
							player.getEntityData().setBoolean("WsC_Donator", true);
						}else if(player.getEntityData().getBoolean("WsC_Donator") == true){
						}
					}
				}
			}
		}
}
