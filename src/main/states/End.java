package main.states;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.buttons.Button;
import main.buttons.ExitListener;
import main.buttons.RestartNextStateListener;
import main.driver.GameDriver;
import main.driver.Player;


public class End extends BasicGameState {
  
  public static final int ID = 3;
  
  private Player winner;
  private Button exit;
  private Button playAgain;
  private Font f;
  
  public End(){
    //Don't know what to put here
  }
  
  public void reset(){
    this.exit.turnOn();
    this.playAgain.turnOn();
  }

  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    this.winner = GameDriver.getPlayers()[GameDriver.getTurn()];
    this.exit = new Button(container, new Image("exit.png"), (int)(GameDriver.X_SIZE * 0.5), (int)(GameDriver.Y_SIZE * 0.7), 200, 52, new ExitListener(container));
    this.exit.setDownImage(new Image("exitSel.png"));
    this.playAgain = new Button(container, new Image("playAgain.png"), (int)(GameDriver.X_SIZE * 0.2), (int)(GameDriver.Y_SIZE * 0.7), 200, 106, new RestartNextStateListener(Menu.ID, game));
    this.playAgain.setDownImage(new Image("playAgainSel.png"));
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
    playAgain.render(container, g);

  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
    // Not sure what to update
    
  }

  @Override
  public int getID() {
    return End.ID;
  }

}
