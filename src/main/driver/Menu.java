package main.driver;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.helper.Button;
import main.helper.ComputerNextStateListener;
import main.helper.HumanNextStateListener;


public class Menu extends BasicGameState {
  
  public static final int ID = 0;
  public static boolean type = true;
  
  private GameDriver game;
  private Button chooseComputer;
  private Button chooseHuman;
  private Image chess;
  
 
  public Menu() {
    //Not sure why we need this.
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    
    this.game = (GameDriver)game;
    chooseComputer = new Button(container, new Image("hVCChoiceButtonSel.png"), (int)(GameDriver.X_SIZE * 0.22), (int)(GameDriver.Y_SIZE * 0.4), 200, 109, new ComputerNextStateListener(Setup.ID, this.game));
    chooseHuman = new Button(container, new Image("hVHChoiceButtonSel.png"), (int)(GameDriver.X_SIZE * 0.52), (int)(GameDriver.Y_SIZE * 0.4), 200, 109, new HumanNextStateListener(Setup.ID, this.game));
    chooseComputer.setDownImage(new Image("hVCChoiceButton.png"));
    chooseHuman.setDownImage(new Image("hvHChoiceButton.png"));
    chess = new Image("Chess.png");
  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    
    g.setBackground(Color.darkGray);
    
    g.setColor(Color.white);
    chess.draw(GameDriver.X_SIZE * 0.22f, GameDriver.Y_SIZE / 6f);
    
    chooseComputer.render(container, g);
    chooseHuman.render(container, g);

  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
     //Not sure what to do w/ this.
  }

  @Override
  public int getID() {
    return Menu.ID;
  }
  
  @Override
  /** keyReleased function.
   *  
   */
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_RIGHT) {
      game.getState(Setup.ID);
      game.enterState(Setup.ID);
    }
  }

}
