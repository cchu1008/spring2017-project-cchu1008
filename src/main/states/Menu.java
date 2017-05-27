package main.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.buttons.Button;
import main.buttons.ComputerNextStateListener;
import main.buttons.HumanNextStateListener;
import main.driver.GameDriver;


public class Menu extends BasicGameState {
  
  public static final int ID = 0;
  private static boolean type = true;
  
  private GameDriver game;
  private Button chooseComputer;
  private Button chooseHuman;
  private Image chess;
  
 
  public Menu() {
    //Don't know what to put here
  }
  
  public void reset(){
    this.chooseComputer.turnOn();
    this.chooseHuman.turnOn();
  }
  
  public static boolean getType(){
    return Menu.type;
  }
  
  public static void setType(boolean b){
    Menu.type = b;
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    this.game = (GameDriver)game;
    chooseComputer = new Button(container, new Image("hVCChoiceButtonSel.png"), (int)(GameDriver.X_SIZE * 0.22), (int)(GameDriver.Y_SIZE * 0.4), 200, 109, new ComputerNextStateListener(Setup.ID, this.game));
    chooseHuman = new Button(container, new Image("hVHChoiceButtonSel.png"), (int)(GameDriver.X_SIZE * 0.52), (int)(GameDriver.Y_SIZE * 0.4), 200, 109, new HumanNextStateListener(Setup.ID, this.game));
    chooseComputer.setDownImage(new Image("hVCChoiceButton.png"));
    chooseHuman.setDownImage(new Image("hvHChoiceButton.png"));
    chess = new Image("chess.png");
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


}
