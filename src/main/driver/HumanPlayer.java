package main.driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class HumanPlayer extends Player {
  public HumanPlayer(String name, boolean white, StateBasedGame game, GameContainer container) {
    super(name, white, game, container);
  }
}
