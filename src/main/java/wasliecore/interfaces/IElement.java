package wasliecore.interfaces;

public interface IElement {
	/**
	 * In here you need to draw the element
	 */
	public void drawElement();
	
	/**
	 * @param mX
	 * Mouse X Position
	 * @param mY
	 * Mouse Y Position
	 * @return is the mouse in a element
	 */
	public boolean isMouseInElement(int mX, int mY);
	
	/**
	 * This get's called when you enter the element
	 * @param mX
	 * Mouse X Position
	 * @param mY
	 * Mouse Y Position
	 */
	
	public void onMouseEnter(int mX, int mY);
	
	/**
	 * This get's called when you click within the element
	 * @param mX
	 * Mouse X Position
	 * @param mY
	 * Mouse Y Position
	 * @param type
	 * Type of click (right, left, scroll)
	 */
	public void onMouseClick(int mX, int mY, int type);
}