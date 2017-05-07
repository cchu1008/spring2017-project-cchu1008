package main.driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;


public class ComputerButton extends NextStateButton {
    /** Button Function.
     * 
     * @param row : row
     * @param col : column
     * @param p : player
     * @param container : container
     * @param image : image
     * @param x : x position
     * @param y : y position
     * @param width : width
     * @param height : height
     */
    public ComputerButton(GameContainer container, Image image, int x, int y, int width, int height, int id, StateBasedGame game) {
      super(container, image, x, y, width, height, id, game);
    }
    
    @Override
    public void mouseReleased(int button, int mx, int my) {
      if (isMouseOver()) {
        super.mouseReleased(button, mx, my);
        Setup.makeHumanVCompPlayers(this.game);
        this.game.enterState(this.id);
      }
    }

}
