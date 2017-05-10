package main.helper;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public abstract class ButtonListener implements ComponentListener{
  public ButtonListener(){
    
  }
  
  public abstract void componentActivated(AbstractComponent source);
}
