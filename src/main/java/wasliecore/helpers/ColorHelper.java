package wasliecore.helpers;

import java.awt.Color;

public class ColorHelper {
	public static int getColorCodeFromRGB(int red, int green, int blue)
	{
		Color color = new Color(red, green, blue);
		
		return color.getRGB();
	}
	
	public static int getColorCodeFromColor(Color color)
	{
		return color.getRGB();
	}
	
	public int getColorCodeFromName(String name)
	{
		return Color.getColor(name).getRGB();
	}
}