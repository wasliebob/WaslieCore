package wasliecore.betascreen;

import java.awt.Color;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import wasliecore.helpers.WarningHelper;

public class GuiWarningScreen extends GuiScreen{
	public GuiWarningScreen(GuiScreen parent){
		this.parent = parent;
	}
    private GuiScreen parent;
    String url_bug = "Not Available";
    
    @SuppressWarnings("unchecked")
	@Override
    public void initGui(){
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, (this.width / 2) - 175, (this.height - 24), 350, 20, "I Agree"));
    }

    @Override
    public void actionPerformed(GuiButton button){
    	if (button.id == 0)
    		this.mc.displayGuiScreen(this.parent);
    }
    
    @Override
    public void drawScreen(int x, int y, float renderPartialTicks){
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Warning!", this.width / 2, 50, Color.cyan.getRGB());

        this.drawCenteredString(this.fontRendererObj, StatCollector.translateToLocal("wsc.warning.1"), this.width / 2, 82, Color.red.getRGB());
   
        for(int i = 0; i < WarningHelper.warnings.size(); i++){
        	String s = WarningHelper.warnings.get(i);
            this.drawCenteredString(this.fontRendererObj, s, this.width / 2, 82 + (10*translateToOne(i)), Color.red.getRGB());
        }
        
        this.drawCenteredString(this.fontRendererObj, StatCollector.translateToLocal("wsc.warning.2"), this.width / 2, 82 + (10) + (10*WarningHelper.warnings.size()), Color.red.getRGB());

        super.drawScreen(x, y, renderPartialTicks);
    }
    
    public int translateToOne(int value){
    	return value == 0 ? 1 : value;
    }
    
    @Override
    public void onGuiClosed(){
        Keyboard.enableRepeatEvents(false);
    }
}