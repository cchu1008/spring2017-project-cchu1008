package main.buttons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.GameDriver;
import main.states.Menu;
import main.states.Play;
import main.states.Setup;

public class TextFieldListener extends NextStateButtonListener {
  private int player;
  private GameContainer cont;
  
  public TextFieldListener(int player, int next, StateBasedGame game, GameContainer cont) {
    super(next, game);
    this.player = player;
    this.cont = cont;
  }

  @Override
  public void componentActivated(AbstractComponent source) {
    GameDriver.getPlayers()[this.player].setName(((TextField)source).getText());
    if(this.player == 0 && !Menu.getType()){
      Setup.getNameOne().setFocus(false);
      Setup.getNameTwo().setFocus(true);
    }
    else if(this.player == 0 && Menu.getType()){
      Setup.getNameOne().setFocus(false);
      sendToPlay();
    }
    else {
      Setup.getNameTwo().setFocus(false);
      sendToPlay();
    }
  }
  
  public void sendToPlay(){
    ((GameDriver)this.getGame()).createState(this.cont, Play.ID);
    this.getGame().enterState(this.getId());
    if(Menu.getType()){
      Setup.makeHumanVCompPlayers(this.getGame(), this.cont);
    }
    else{
      Setup.makeHumanVHumanPlayers(this.getGame());
    }
  }

}
