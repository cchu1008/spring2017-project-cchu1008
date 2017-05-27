package main.buttons;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;

import main.states.Menu;

public class ComputerNextStateListener extends NextStateButtonListener {

  public ComputerNextStateListener(int id, StateBasedGame game) {
    super(id, game);
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    super.componentActivated(source);
    Menu.type = true;
  }

}
