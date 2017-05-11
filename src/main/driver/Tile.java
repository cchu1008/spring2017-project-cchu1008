package main.driver;

import main.helper.Position;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;


public class Tile extends MouseOverArea {
  private int row;
  private int col;
  private Player[] players;
  
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
  public Tile(int row, int col, Player[] p, GameContainer container, 
      Image image, int x, int y, int width, int height) {
    super(container, image, x, y, width, height);
    this.row = row;
    this.col = col;
    this.players = p;
  }
  
  @Override
  public void mouseReleased(int button, int mx, int my) {
    if (isMouseOver()) {
      super.mouseReleased(button, mx, my);
      players[GameDriver.turn].pickTile(new Position(this.row, this.col));
      Logger.getLogger("BoardLogger").log(Level.SEVERE, null, "Button clicked at (" + this.row + ", " + this.col + ")");
    }
  }
  
  public int getRow() {
    return this.row;
  }
  
  public int getCol() {
    return this.col;
  }
}
