package main.driver;

import main.helper.Position;
import main.piece.Piece;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public abstract class Player {
  public String name;
  private boolean white;
  public GameDriver game;
  private Position begin = new Position(-1, -1);
  private Position end = new Position(-1, -1);
  private Piece piece;
  private GameContainer container;
  
  /** Player constructor.
   * 
   * @param name : name
   * @param white : boolean whether white or not
   * @param game : game
   * @param container : container
   */
  public Player(String name, boolean white, StateBasedGame game, GameContainer container) {
    this.name = name;
    this.white = white;
    this.game = (GameDriver) game;
    this.container = container;
  }
  
  public void setWhite(boolean white) {
    this.white = white;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public boolean isWhite() {
    return this.white;
  }
  
  /** pickTile function.
   * 
   * @param p : Position
   */
  public void pickTile(Position p) {
    String normal = this.name + " Begin: (" + this.begin.getX() + ", " 
        + this.begin.getY() + ") ; End: (" + this.end.getX() + ", " + this.end.getY() + ")";
    String invalid = "Invalid move: (" + this.begin.getX() + ", " 
        + this.begin.getY() + ") to (" + this.end.getX() + ", " + this.end.getY() + ")";
    
    if (!GameDriver.isEmpty(p) 
        && (GameDriver.board[p.getX()][p.getY()].isWhite() == this.isWhite())) {
      this.begin.setPos(p);
      this.piece = GameDriver.board[p.getX()][p.getY()];
      this.piece.printValid();

      System.out.println(normal);
    } else if (!this.begin.equals(new Position(-1, -1)) && this.end.equals(new Position(-1, -1))) {
      if (this.piece.isValid(p)) {
        this.end.setPos(p);
        try {
          GameDriver.move(this.begin, this.end, this.game, this.container);
        } catch (SlickException e) {
          System.err.println(e);
        }
        System.out.println(normal);
        resetPosition();
      } else {
        System.out.println(invalid);
        resetPosition();
      }

    } else {
      System.out.println(invalid);
      resetPosition();
    }
  }
  
  public Position getStart() {
    return this.begin;
  }
  
  public Position getEnd() {
    return this.end;
  }
  
  public void resetPosition() {
    this.begin = new Position(-1, -1);
    this.end = new Position(-1, -1);
  }
  
}
