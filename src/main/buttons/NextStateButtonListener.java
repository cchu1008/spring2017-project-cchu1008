package main.buttons;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;

public abstract class NextStateButtonListener implements ComponentListener {
  private int id;
  private StateBasedGame game;
  
  public NextStateButtonListener(int id, StateBasedGame game){
    this.id = id;
    this.game = game;
  }
  
  public int getId(){
    return this.id;
  }
  
  public StateBasedGame getGame(){
    return this.game;
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    ((Button)source).setOn(false);
    source.setAcceptingInput(((Button)source).getOn());
    this.game.enterState(this.id);
  }

}
