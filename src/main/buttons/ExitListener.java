package main.buttons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class ExitListener implements ComponentListener {
  public GameContainer container;

  public ExitListener(GameContainer container) {
    this.container = container;
  }

  @Override
  public void componentActivated(AbstractComponent source) {
    ((Button)source).on = false;
    source.setAcceptingInput(((Button)source).on);
    this.container.exit();

  }

}
