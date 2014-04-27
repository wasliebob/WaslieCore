package wasliecore.handlers.commands;

import wasliecore.helpers.DateHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
public class CommandWSC extends CommandBase{

	@Override
	public String getCommandName() {
		return "wsc";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/wsc";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] array) {
		if(sender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)sender;
			if(array.length > 0){
				if(array[0] != null && array[0].equals("help")){
					String[] commands = new String[]{
							"/wsc help",
							"/wsc dev",
							"/wsc mods",
							"/wsc date"};
					sendArray(player, commands);
				}else if(array[0] != null && array[0].equals("dev")){
					if(array.length >= 2 && array[1] != null && array[1].equals("twitter")){
							sendMessage(player, EnumChatFormatting.BLUE + "https://twitter.com/Wasliebob");
						}else if(array.length >= 2 && array[1] != null && array[1].equals("mods")){
							String[] mods = new String[]{
								"Thaumcraft Extras",
								"Thaumcraft Extras 2",
								"Forestry Extras",
								"Forestry Extras 2"};
							sendArray(player, mods);
						}else if(array.length >= 2 && array[1] != null && array[1].equals("donate")){
							sendMessage(player, EnumChatFormatting.BLUE + "Want to support wasliebob with all his hard work feel free to donate at " + "https://www.paypal.com/nl/cgi-bin/webscr?cmd=_flow&SESSION=vw4Zf6DkU80NwwFJOcVcBtQpTnqX7ddlTbPk9awAXPqbKM2FU23rE-x4SL4&dispatch=5885d80a13c0db1f8e263663d3faee8d8cdcf517b037b4502f6cc98f1ee6e5fb");
						}else if(array.length >= 2 && array[1] != null && array[1].equals("patreon")){
							sendMessage(player, EnumChatFormatting.BLUE + "Want to support wasliebob with all his hard work feel free to become a patreon and support wasliebob at " + "http://www.patreon.com/wasliebob");
						}else{
							String[] devCommands = new String[]{
									"twitter",
									"mods",
									"donate",
									"patreon"};
							sendArray(player, devCommands);
						}
				}else if(array[0] != null && array[0].equals("mods")){
					String[] mods = new String[]{
						"Forestry Extras 2",
						"Thaumcraft Extras 2"};
					sendArray(player, mods);
				}else if(array[0] != null && array[0].equals("date")){
					sendMessage(player, DateHelper.getCurrentFullDate());
				}else{
					
				}
			}else{
				sendMessage(player, EnumChatFormatting.RED + "/wsc help");
			}
		}
	}

	public void setColor(int color, EntityPlayer player)
	{
		player.getCurrentEquippedItem().stackTagCompound.setInteger("Color" + player.getDisplayName(), color);
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	
	public static void sendArray(EntityPlayer player, String[] text)
	{
		for(String s : text)
		{
			sendMessage(player, EnumChatFormatting.BLUE + s);
		}
	}
	
	public static void sendMessage(EntityPlayer player, String text)
	{
		player.addChatComponentMessage(new ChatComponentText(text));
	}
}