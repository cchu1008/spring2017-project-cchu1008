package main.buttons;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.GameDriver;

public class RestartNextStateListener extends NextStateButtonListener {

  public RestartNextStateListener(int id, StateBasedGame game) {
    super(id, game);
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    Logger restartLogger = Logger.getLogger("RestartLogger");
    ((GameDriver)this.getGame()).createState(((Button)source).getContainer(), this.getId());
    super.componentActivated(source);
    try {
      GameDriver.clearBoard();
      ((GameDriver) this.getGame()).init(((Button)source).getContainer());
      GameDriver.setTurn(0);
    } catch (SlickException e) {
      restartLogger.log(Level.SEVERE, "Unable to restart game", "");
    }
  }

}
