package main.driver;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.helper.Button;
import main.helper.PlayNextStateListener;


public class Setup extends BasicGameState {
  
  public static final int ID = 1;
  
  private GameDriver game;
  private static TextField nameOne;
  private static TextField nameTwo;
  private Button next;
  
  public Setup(){
    //Not sure why we need this.
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    this.game = (GameDriver)game;
    this.next = new Button(container, new Image("main/resources/nextButton.png"), GameDriver.X_SIZE / 4, (int)(GameDriver.Y_SIZE * 0.7), 92, 50, new PlayNextStateListener(Play.ID, this.game));
    
    ((GameDriver)game).setPlayers((Player)new HumanPlayer("Player One", true, game, container), (Player)new HumanPlayer("Player Two", false, game, container));
    
    Setup.nameOne = new TextField(container, 
        new TrueTypeFont(new java.awt.Font("Verdana", 0, 16), true), 
        GameDriver.X_SIZE / 4, GameDriver.Y_SIZE / 3, 300, 30);
    Setup.nameTwo = new TextField(container, 
        new TrueTypeFont(new java.awt.Font("Verdana", 0, 16), true), 
        GameDriver.X_SIZE / 4, GameDriver.Y_SIZE / 2, 300, 30);
  
  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    chooseRender(container, g, Menu.type);
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
    Input input = container.getInput();
    if (input.isKeyDown(Input.KEY_UP)) {
      //Code here?
    }
  }

  @Override
  public int getID() {
    return Setup.ID;
  }
  
  @Override
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_RIGHT || key == Input.KEY_2) {
      game.getState(Play.ID);
      game.enterState(Play.ID);
    }
    if (key == Input.KEY_LEFT || key == Input.KEY_0) {
      game.getState(Menu.ID);
      game.enterState(Menu.ID);
    }
    if (key == Input.KEY_3) {
      game.getState(End.ID);
      game.enterState(End.ID);
    }
  }
  
  public void chooseRender(GameContainer container, Graphics g, boolean computer) throws SlickException {
    if(computer){
      humanVComp(container, g);
    }
    else
      humanVHuman(container, g);
  }
  
  public void humanVComp(GameContainer container, Graphics g){
    g.setColor(Color.red);
    g.drawString("This is the Setup State", GameDriver.X_SIZE * 0.360f, GameDriver.Y_SIZE / 8f);
    g.setColor(Color.white);
    g.drawString("State Based Game Test", GameDriver.X_SIZE * 0.365f, GameDriver.Y_SIZE / 6f);
    g.drawString("Numbers 0-3 will switch between states.", 
        GameDriver.X_SIZE * 0.255f, GameDriver.Y_SIZE / 4f);
    
    g.drawString("Player One: ", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 3f);
    g.drawString("Player Two: CPU", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 2f);
    
    Setup.nameOne.render(container, g);
    this.next.render(container, g);
  }
  
  public void humanVHuman(GameContainer container, Graphics g){
    g.setColor(Color.red);
    g.drawString("This is the Setup State", GameDriver.X_SIZE * 0.360f, GameDriver.Y_SIZE / 8f);
    g.setColor(Color.white);
    g.drawString("State Based Game Test", GameDriver.X_SIZE * 0.365f, GameDriver.Y_SIZE / 6f);
    g.drawString("Numbers 0-3 will switch between states.", 
        GameDriver.X_SIZE * 0.255f, GameDriver.Y_SIZE / 4f);
    
    g.drawString("Player One: ", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 3f);
    g.drawString("Player Two: ", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 2f);
    
    Setup.nameOne.render(container, g);
    Setup.nameTwo.render(container, g);
    this.next.render(container, g);
  }
  
  public static void makeHumanVCompPlayers(StateBasedGame game, GameContainer container){
    ((GameDriver)game).players[0].setName(Setup.nameOne.getText());
    ((GameDriver)game).players[1] = new ComputerPlayer(game, container);
  }
  
  public static void makeHumanVHumanPlayers(StateBasedGame game){
    ((GameDriver)game).players[0].setName(Setup.nameOne.getText());
    ((GameDriver)game).players[1].setName(Setup.nameTwo.getText());
  }

}
