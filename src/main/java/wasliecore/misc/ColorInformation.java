package wasliecore.misc;

import java.awt.Color;

public class ColorInformation {
	public ColorInformation(Color color){
		this.color = color;
		this.red = color.getRed();
		this.green = color.getGreen();
		this.blue = color.getBlue();
	}
	
	public ColorInformation(int red, int green, int blue){
		this.color = new Color(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	public Color color;
	public int red;
	public int green;
	public int blue;
}