package wasliecore.enums;

public enum EnumIcon {
	NORMAL(16);
	
	private EnumIcon(int size){
		this.size = size;
	}
	public int size;
	
	public int getSize(){
		return this.size;
	}
}