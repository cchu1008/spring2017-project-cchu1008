package main.helper;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class ExitListener implements ComponentListener {
  public boolean on = true;
  public GameContainer container;

  public ExitListener(GameContainer container) {
    this.container = container;
  }

  @Override
  public void componentActivated(AbstractComponent source) {
    this.on = false;
    source.setAcceptingInput(this.on);
    this.container.exit();

  }

}
