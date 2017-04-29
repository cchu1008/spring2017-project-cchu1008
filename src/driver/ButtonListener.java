package driver;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class ButtonListener implements ComponentListener{
	public ButtonListener(){
		super();
	}
	
	public void componentActivated(AbstractComponent source){
		System.out.println("Source: " + source);
	}
}
