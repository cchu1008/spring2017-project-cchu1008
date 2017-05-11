package main.helper;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class Button extends MouseOverArea {
  public GameContainer cont;
  
  public Button(GameContainer container, Image image, int x, int y, int width, int height, ComponentListener listener){
    super(container, image, x, y, width, height, listener);
    this.cont = container;
  }
  
  @Override
  public void mouseReleased(int button, int mx, int my) {
    if (isMouseOver()) {
      super.mouseReleased(button, mx, my);
    }
  }
  
  public void setDownImage(Image image){
    this.setMouseOverImage(image);
    this.setMouseDownImage(image);
  }
}
