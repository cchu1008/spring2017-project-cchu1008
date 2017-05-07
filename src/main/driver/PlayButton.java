package main.driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class PlayButton extends NextStateButton {
  public PlayButton(GameContainer container, Image image, int x, int y, int width, int height, StateBasedGame game) {
    super(container, image, x, y, width, height, Setup.ID, game);
  }
  
  @Override
  public void mouseReleased(int button, int mx, int my) {
    if (isMouseOver()) {
      super.mouseReleased(button, mx, my);
      this.game.enterState(Setup.ID);
    }
  }
}
