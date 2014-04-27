package wasliecore.handlers.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import wasliecore.helpers.DateHelper;
import wasliecore.main.WaslieCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OnPlayerJoinEvent {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public void joinEvent(EntityJoinWorldEvent e)
    {
		if(!e.world.isRemote){
			if(e.entity instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)e.entity;
				if(player.getDisplayName() != null){
					sendMessage(DateHelper.getCurrentDate(), player, EnumChatFormatting.RED);
				}
			}
		}
    }
	
	public void sendMessage(String text, EntityPlayer player, EnumChatFormatting color){
		player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[" + WaslieCore.alias + "] " + color + text));
	}
}