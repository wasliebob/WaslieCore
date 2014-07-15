package wasliecore.enums;

public enum EnumDyes {
	BONEMEAL(15);
	
	private EnumDyes(int value){
		
	}
	public int value;
	
	public int getValue(){
		return this.value;
	}
}