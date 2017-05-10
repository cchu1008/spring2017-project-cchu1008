package main.helper;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.GameDriver;
import main.driver.Menu;
import main.driver.Setup;


public class PlayNextStateListener extends NextStateButtonListener {

  public PlayNextStateListener(int id, StateBasedGame game) {
    super(id, game);
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    System.out.println("PlayNextStateListener");
    super.componentActivated(source);
    ((GameDriver)this.game).goToPlay(((Button)source).container);
    if(Menu.type){
      Setup.makeHumanVCompPlayers(this.game);
    }
    else{
      Setup.makeHumanVHumanPlayers(this.game);
    }
  }

}
