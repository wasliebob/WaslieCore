package wasliecore.handlers.events;

import wasliecore.betascreen.GuiWarningScreen;
import wasliecore.helpers.WarningHelper;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StartupEvent {    
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void displayWarning(GuiOpenEvent e){
		if(e.gui instanceof GuiMainMenu && !WarningHelper.warnings.isEmpty()){
            e.gui = new GuiWarningScreen(e.gui);
            MinecraftForge.EVENT_BUS.unregister(this);
		}
	}
}