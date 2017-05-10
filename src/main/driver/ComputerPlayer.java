package main.driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class ComputerPlayer extends Player {
  public ComputerPlayer(StateBasedGame game, GameContainer container) {
    super("CPU", false, game, container);
  }
}
