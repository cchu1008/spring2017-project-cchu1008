package main.driver;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.helper.Button;
import main.helper.ExitListener;


public class End extends BasicGameState {
  
  public static final int ID = 3;
  
  private GameDriver game;
  private Player winner;
  private Button exit;
  private Font f;
  
  public End(){
    //Not sure why we need this.
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    this.game = (GameDriver)game;
    this.winner = ((GameDriver)game).players[GameDriver.turn];
    this.exit = new Button(container, new Image("exit.png"), (int)(GameDriver.X_SIZE * 0.5), (int)(GameDriver.Y_SIZE * 0.7), 200, 52, new ExitListener(container));
    this.exit.setDownImage(new Image("exitSel.png"));
    f = new TrueTypeFont(new java.awt.Font("Serif", 0, 40), false);
  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    g.setFont(this.f);
    g.setColor(Color.white);
    g.drawString("The winner is: " + this.winner.getName(), 
        GameDriver.X_SIZE * 0.2f, GameDriver.Y_SIZE / 4f);
    exit.render(container, g);

  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
    // Not sure what to update
    
  }

  @Override
  public int getID() {
    return End.ID;
  }
  
  @Override
  /** keyReleased function.
   * 
   */
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_LEFT || key == Input.KEY_2) {
      game.getState(Play.ID);
      game.enterState(Play.ID);
    }
    if (key == Input.KEY_0) {
      game.getState(Menu.ID);
      game.enterState(Menu.ID);
    }
    if (key == Input.KEY_1) {
      game.getState(Setup.ID);
      game.enterState(Setup.ID);
    }
  }

}
