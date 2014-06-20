package wasliecore.enums;

public enum EnumWrenchTiers {
	WOOD(0, false), IRON(1, false), DIAMOND(2, false), HEAT(3, true), NETHERSTAR(4, true);
	
	private EnumWrenchTiers(int tier, boolean isForced){
		this.tier = tier;
		this.isForced = isForced;
	}
	private int tier;
	private boolean isForced;
	
	public int getTier(){
		return this.tier;
	}
	
	public boolean isForced(){
		return this.isForced;
	}
}