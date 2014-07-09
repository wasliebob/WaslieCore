package wasliecore.helpers;

import java.awt.Color;

import wasliecore.misc.ColorInformation;

public class ColorHelper {
	public static int getColorCodeFromRGB(int red, int green, int blue){
		Color color = new Color(red, green, blue);
		
		return color.getRGB();
	}
	
	public static int getColorCodeFromColor(Color color){
		return color.getRGB();
	}
	
	public int getColorCodeFromName(String name){
		return Color.getColor(name).getRGB();
	}
	
	public static ColorInformation getColorInfoFromColor(Color color){
		ColorInformation info = new ColorInformation(color);
		return info;
	}
	
	public static ColorInformation getColorInfoFromRGB(int red, int green, int blue){
		ColorInformation info = new ColorInformation(red, green, blue);
		
		return info;
	}
}