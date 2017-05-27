package main.buttons;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.GameDriver;
import main.states.Menu;
import main.states.Play;
import main.states.Setup;


public class PlayNextStateListener extends NextStateButtonListener {

  public PlayNextStateListener(int id, StateBasedGame game) {
    super(id, game);
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    ((GameDriver)this.getGame()).createState(((Button)source).getContainer(), Play.ID);
    super.componentActivated(source);
    if(Menu.type){
      Setup.makeHumanVCompPlayers(this.getGame(), ((Button)source).getContainer());
    }
    else{
      Setup.makeHumanVHumanPlayers(this.getGame());
    }
  }

}
