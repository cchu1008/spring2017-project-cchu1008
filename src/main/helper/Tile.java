package main.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.GameState;

import main.driver.GameDriver;
import main.driver.Player;


public class Tile extends MouseOverArea {
  private int row;
  private int col;
  private Player[] players;
  private GameDriver game;
  private GameState play;
  private Image overImage;
  private Image normalImage;
  
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
      Image image, Position pos, Position widthHeight, GameDriver game, GameState play) {
    super(container, image, pos.getX(), pos.getY(), widthHeight.getX(), widthHeight.getY());
    this.row = row;
    this.col = col;
    this.players = p;
    this.game = game;
    this.play = play;
    this.normalImage = image;
  }
  
  public void mousedOver(){
    this.setNormalImage(this.overImage);
  }
  
  public void reset(){
    this.setNormalImage(this.normalImage);
  }
  
  @Override
  public void mouseReleased(int button, int mx, int my) {
    if (isMouseOver()) {
      super.mouseReleased(button, mx, my);
      players[GameDriver.getTurn()].pickTile(new Position(this.row, this.col));
      Logger.getLogger("BoardLogger").log(Level.SEVERE, null, "Button clicked at (" + this.row + ", " + this.col + ")");
    }
  }
  
  @Override
  public void setMouseOverImage(Image im){
    super.setMouseOverImage(im);
    this.overImage = im;
  }
  
  public void check(){
    if(isMouseOver()){
      this.game.lightUpValid(this.play, new Position(this.row, this.col));
    }
  }
  
  
  public int getRow() {
    return this.row;
  }
  
  public int getCol() {
    return this.col;
  }
}
