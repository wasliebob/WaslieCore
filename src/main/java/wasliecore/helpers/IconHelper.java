package wasliecore.helpers;

import net.minecraft.client.renderer.Tessellator;

public class IconHelper {
	public static int normalSize = 16;
	
	public static void draw2DIcon(int x, int y, int width, int height, float zLevel){
	    Tessellator t = Tessellator.instance;
	    t.startDrawingQuads();
	    t.addVertexWithUV(x + 0, y + height, zLevel, 0D, 1D);
	    t.addVertexWithUV(x + width, y + height, zLevel, 1D, 1D);
	    t.addVertexWithUV(x + width, y + 0, zLevel, 1D, 0D);
	    t.addVertexWithUV(x + 0, y + 0, zLevel, 0D, 0D);
	    t.draw();
	}
	
	public static void draw2DIconWithColor(int x, int y, int width, int height, float zLevel, int red, int green, int blue){
	    Tessellator t = Tessellator.instance;
	    t.startDrawingQuads();
		t.setColorOpaque(red, green, blue);
	    t.addVertexWithUV(x + 0, y + height, zLevel, 0D, 1D);
	    t.addVertexWithUV(x + width, y + height, zLevel, 1D, 1D);
	    t.addVertexWithUV(x + width, y + 0, zLevel, 1D, 0D);
	    t.addVertexWithUV(x + 0, y + 0, zLevel, 0D, 0D);
	    t.draw();
	}
}