package driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class Button extends MouseOverArea{
	private int row;
	private int col;
	
	public Button(int row, int col, GameContainer container, Image image, int x, int y, int width, int height, ComponentListener listener){
		super(container, image, x, y, width, height, listener);
		this.row = row;
		this.col = col;
	}
	
	@Override
	public void mouseReleased(int button, int mx, int my){
		if(mx > this.getX() && mx < (this.getX() + this.getWidth()) && my > this.getY() && my < (this.getY() + this.getHeight())){
			super.mouseReleased(button,  mx, my);
			System.out.println("Button clicked at (" + this.row + ", " + this.col + ")");
		}
	}
}
