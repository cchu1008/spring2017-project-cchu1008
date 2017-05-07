package main.driver;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Menu extends BasicGameState {
  
  public static final int ID = 0;
  public static boolean type = true;
  
  private GameDriver game;
  private NextStateButton playButton;
  private Button chooseComputer;
  private Button chooseHuman;
  
 
  public Menu() {
    //Not sure why we need this.
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    
    this.game = (GameDriver)game;
    playButton = new PlayButton(container, new Image("main/resources/playButton.png"), (int)(GameDriver.X_SIZE * 0.25), (int)(GameDriver.Y_SIZE * 0.6), 200, 52, game);
    chooseComputer = new Button(container, new Image("main/resources/hVCChoiceButton.png"), (int)(GameDriver.X_SIZE * 0.25), (int)(GameDriver.Y_SIZE * 0.4), 200, 109);
    chooseHuman = new Button(container, new Image("main/resources/hVHChoiceButton.png"), (int)(GameDriver.X_SIZE * 0.55), (int)(GameDriver.Y_SIZE * 0.4), 200, 109);
    chooseComputer.setDownImage(new Image("main/resources/hVCChoiceButtonSel.png"));
    chooseHuman.setDownImage(new Image("main/resources/hvHChoiceButtonSel.png"));
  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    
    g.setBackground(Color.lightGray);
    
    g.setColor(Color.red);
    g.drawString("This is the Menu State", GameDriver.X_SIZE * 0.360f, GameDriver.Y_SIZE / 8);
    g.setColor(Color.white);
    g.drawString("State Based Game Test", GameDriver.X_SIZE * 0.365f, GameDriver.Y_SIZE / 6);
    g.drawString("Numbers 0-3 will switch between states.", 
        GameDriver.X_SIZE * 0.255f, GameDriver.Y_SIZE / 4);
    
    chooseComputer.render(container, g);
    chooseHuman.render(container, g);
    playButton.render(container, g);

  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
    int posX = Mouse.getX();
    int posY = Mouse.getY();
    
    if (Mouse.isButtonDown(0) && posX > (GameDriver.X_SIZE * 0.15f + 42) 
        && posX < ((GameDriver.X_SIZE * 0.15f + 42) + 376) 
        && posY < (GameDriver.Y_SIZE * 0.5f - 12) 
        && posY > ((GameDriver.Y_SIZE * 0.5f - 12) - 95)) {
      game.enterState(Setup.ID);
    }
  }

  @Override
  public int getID() {
    return Menu.ID;
  }
  
  /** keyReleased function.
   *  
   */
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_RIGHT || key == Input.KEY_1) {
      game.getState(Setup.ID);
      game.enterState(Setup.ID);
    }
    if (key == Input.KEY_2) {
      game.getState(Play.ID);
      game.enterState(Play.ID);
    }
    if (key == Input.KEY_3) {
      game.getState(End.ID);
      game.enterState(End.ID);
    }
  }

}
