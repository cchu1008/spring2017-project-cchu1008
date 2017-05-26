package main.driver;

import main.helper.Move;
import main.helper.Position;
import main.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public abstract class Player {
  private String name;
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
    this.game = (GameDriver)game;
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
    Logger boardLogger = Logger.getLogger("BoardLogger");
    String normal = this.name + " Begin: (" + this.begin.getX() + ", " 
        + this.begin.getY() + ") ; End: (" + this.end.getX() + ", " + this.end.getY() + ")";
    String invalid = "Invalid move: (" + this.begin.getX() + ", " 
        + this.begin.getY() + ") to (" + this.end.getX() + ", " + this.end.getY() + ")";
    
    if (!GameDriver.isEmpty(p) 
        && (GameDriver.board[p.getX()][p.getY()].isWhite() == this.isWhite())) {
      this.begin.setPos(p);
      this.piece = GameDriver.board[p.getX()][p.getY()];
      this.piece.printValid();
      boardLogger.log(Level.SEVERE, null, normal);
    } else if (!this.begin.equals(new Position(-1, -1)) && this.end.equals(new Position(-1, -1))) {
      if (this.piece.isValid(p)) {
        this.end.setPos(p);
        try {
          GameDriver.move(this.begin, this.end, this.game, this.container);
        } catch (SlickException ex) {
          Logger.getLogger("GameMoveLogger").log(Level.SEVERE, null, ex);
        }
        boardLogger.log(Level.SEVERE, null, normal);
        resetPosition();
      } else {
        boardLogger.log(Level.SEVERE, null, invalid);
        resetPosition();
      }

    } else {
      boardLogger.log(Level.SEVERE, null, invalid);
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
  
  public void movePiece(){
    ArrayList<Move> availableMoves = (ArrayList<Move>)getAvailableMoves();
    Move picked = null;
    
    if(!availableMoves.isEmpty()){
      picked = availableMoves.get((int) (Math.random()* availableMoves.size()));
      Logger moveLogger = Logger.getLogger("MoveLogger");
      
      this.pickTile(picked.getStart());
      moveLogger.log(Level.INFO, "Start: " + picked.getStart().toString(), "");
      
      this.pickTile(picked.getEnd());
      moveLogger.log(Level.INFO, "End: " + picked.getEnd().toString(), "");
    }
    
  }
  
  public List<Move> getAvailableMoves(){
    ArrayList<Move> availableMoves = new ArrayList<>();
    
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        addMoves(availableMoves, i, j);
      }
    }
    return availableMoves;
  }
  
  public void addMoves(ArrayList<Move> availableMoves, int i, int j){
    ArrayList<Position> chosen = null;
    
    if(GameDriver.board[i][j] != null && GameDriver.board[i][j].isWhite() == this.isWhite()){
      chosen = (ArrayList<Position>) GameDriver.board[i][j].getValid();
      for(int k = 0; k < chosen.size(); k++){
        if(!GameDriver.board[i][j].getLocation().equals(chosen.get(k))){
          availableMoves.add(new Move(GameDriver.board[i][j].getLocation(), chosen.get(k)));
        }
      }
    }
  }
  
}
