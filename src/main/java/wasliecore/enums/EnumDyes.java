package wasliecore.enums;

public enum EnumDyes {
	INK(0), ROSE(1), CACTUS(2), CACAO(3), LAPIS(4), PURPLE(5), CYAN(6), LIGHTGRAY(7), GRAY(8), PINK(9), LIME(10), YELLOW(11), LIGHTBLUE(12), MAGENTA(13), ORANGE(14), BONEMEAL(15);
	
	private EnumDyes(int value){
		
	}
	public int value;
	
	public int getValue(){
		return this.value;
	}
}