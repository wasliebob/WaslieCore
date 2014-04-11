package wasliecore.handlers.events;

import wasliecore.helpers.UpdateHelper;
import wasliecore.main.WaslieCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
					if(UpdateHelper.getUpdate(WaslieCore.alias) != null){
						if(UpdateHelper.getVersion(WaslieCore.alias) != null && UpdateHelper.getVersion(WaslieCore.alias) > WaslieCore.version){
							if(UpdateHelper.getText(WaslieCore.alias) != null){
								sendMessage("There is a new version of Waslie Core available", player, EnumChatFormatting.RED);
								sendMessage(UpdateHelper.getText(WaslieCore.alias), player, EnumChatFormatting.GRAY);
							}
						}
					}
				}
			}
		}
    }
	
	public void sendMessage(String text, EntityPlayer player, EnumChatFormatting color){
		player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[" + WaslieCore.alias + "] " + color + text));
	}
}