package main.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.buttons.Button;
import main.buttons.PlayNextStateListener;
import main.buttons.TextFieldListener;
import main.driver.ComputerPlayer;
import main.driver.GameDriver;
import main.driver.HumanPlayer;
import main.driver.Player;


public class Setup extends BasicGameState {
  
  public static final int ID = 1;
  
  private GameDriver game;
  private static TextField nameOne;
  private static TextField nameTwo;
  private Button next;
  private final TrueTypeFont FONT = new TrueTypeFont(new java.awt.Font("Verdana", 0, 16), true);
  private Image chess;
  
  public Setup(){
    //Nothing here?
  }
  
  public void reset(GameContainer container, StateBasedGame game){
    this.next.turnOn();
    Setup.setNameOne(new TextField(container, 
        FONT, GameDriver.X_SIZE / 4, GameDriver.Y_SIZE / 3, 300, 30, new TextFieldListener(0, Play.ID, game, container)));
    Setup.setNameTwo(new TextField(container, 
        FONT, GameDriver.X_SIZE / 4, GameDriver.Y_SIZE / 2, 300, 30, new TextFieldListener(1, Play.ID, game, container)));
    
    Setup.getNameOne().setAcceptingInput(true);
    Setup.getNameTwo().setAcceptingInput(true);
    
    Setup.getNameOne().setFocus(true);
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    this.game = (GameDriver)game;
    this.next = new Button(container, new Image("nextButton.png"), (int)(GameDriver.X_SIZE * 0.8), (int)(GameDriver.Y_SIZE * 0.7), 92, 50, new PlayNextStateListener(Play.ID, this.game));
    next.setDownImage(new Image("nextButtonSel.png"));
    chess = new Image("chess.png");
    
    GameDriver.setPlayers((Player)new HumanPlayer("", true, game, container), (Player)new HumanPlayer("", false, game, container));
    
    Setup.setNameOne(new TextField(container, 
        FONT, GameDriver.X_SIZE / 4, GameDriver.Y_SIZE / 3, 300, 30, new TextFieldListener(0, Play.ID, game, container)));
    Setup.setNameTwo(new TextField(container, 
        FONT, GameDriver.X_SIZE / 4, GameDriver.Y_SIZE / 2, 300, 30, new TextFieldListener(1, Play.ID, game, container)));
    
    Setup.getNameOne().setFocus(true);
    
    //this.reset(container);
  
  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    g.setColor(Color.white);
    chess.draw(GameDriver.X_SIZE * 0.22f, GameDriver.Y_SIZE / 10f);
    chooseRender(container, g, Menu.getType());
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
    //FONT.loadGlyphs();
  }

  @Override
  public int getID() {
    return Setup.ID;
  }
  
  public void chooseRender(GameContainer container, Graphics g, boolean computer) throws SlickException {
    if(computer){
      humanVComp(container, g);
    }
    else
      humanVHuman(container, g);
  }
  
  public void humanVComp(GameContainer container, Graphics g){
    g.setColor(Color.white);
    
    g.drawString("Player One: ", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 3f);
    g.drawString("Player Two: CPU", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 2f);
    
    Setup.getNameOne().render(container, g);
    this.next.render(container, g);
  }
  
  public void humanVHuman(GameContainer container, Graphics g){
    g.setColor(Color.white);
    
    g.drawString("Player One: ", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 3f);
    g.drawString("Player Two: ", GameDriver.X_SIZE / 10f, GameDriver.Y_SIZE / 2f);
    
    Setup.getNameOne().render(container, g);
    Setup.getNameTwo().render(container, g);
    this.next.render(container, g);
  }
  
  public static void makeHumanVCompPlayers(StateBasedGame game, GameContainer container){
    if(GameDriver.getPlayers()[0].getName().equals("")){
      GameDriver.getPlayers()[0].setName(Setup.getNameOne().getText());
    }
    GameDriver.getPlayers()[1] = new ComputerPlayer(game, container);
  }
  
  public static void makeHumanVHumanPlayers(StateBasedGame game){
    if(GameDriver.getPlayers()[0].getName().equals("")){
      GameDriver.getPlayers()[0].setName(Setup.getNameOne().getText());
    }
    if(GameDriver.getPlayers()[1].getName().equals("")){
      GameDriver.getPlayers()[1].setName(Setup.getNameTwo().getText());
    }
  }

  public static TextField getNameOne() {
    return nameOne;
  }

  public static void setNameOne(TextField nameOne) {
    Setup.nameOne = nameOne;
  }

  public static TextField getNameTwo() {
    return nameTwo;
  }

  public static void setNameTwo(TextField nameTwo) {
    Setup.nameTwo = nameTwo;
  }

}
