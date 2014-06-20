package wasliecore.proxies;

import net.minecraft.client.Minecraft;

public class ClientProxy extends CommonProxy {
	@Override
	public boolean entityView(){
		return Minecraft.getMinecraft().renderViewEntity != null;
	}
}
