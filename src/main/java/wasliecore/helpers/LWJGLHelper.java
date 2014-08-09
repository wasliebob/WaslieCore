package wasliecore.helpers;

import org.lwjgl.opengl.GL11;

public class LWJGLHelper {
	public static void drawLine(int x, int y, int width, int height){
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_LINES);
		
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x + width, y + height);

		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
}