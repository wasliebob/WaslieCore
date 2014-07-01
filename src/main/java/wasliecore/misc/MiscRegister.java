package wasliecore.misc;

import wasliecore.interfaces.IInitalization;

public class MiscRegister implements IInitalization{

	@Override
	public void preInit() {
		we = new ItemWE();
	}
	public static ItemWE we;
	
	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}
}