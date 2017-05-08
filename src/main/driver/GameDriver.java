package main.driver;

import main.helper.Position;
import main.piece.Pawn;
import main.piece.Piece;
import main.piece.Queen;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



public class GameDriver extends StateBasedGame {
  public static final String GAME = "Chess";
  public static final int MENU = 0;
  public static final int SETUP = 1;
  public static final int PLAY = 2;
  public static final int END = 3;
  public static final int FPS = 300;
  public static final int X_SIZE = 700;
  public static final int Y_SIZE = 650;
  
  public static Piece[][] board = new Piece[8][8];
  public static Player[] players = new Player[2];
  
  public static int turn = 0;
  
  /** GameDriver constructor.
   * 
   * @param name : Name of game
   */
  public GameDriver(String name) {
    super(name);
    this.addState(new Menu());
    this.addState(new Play());
    this.addState(new End());
    this.addState(new Setup());
  }
  
  /** Move Function.
   * 
   * @param start : Start position
   * @param end : End position
   * @throws SlickException : Throws slick exception
   */
  public void move(Position start, Position end) throws SlickException {
    Piece p = GameDriver.board[start.getX()][start.getY()];
    GameDriver.board[start.getX()][start.getY()] = null;
    p.move(end);
    if (!GameDriver.isEmpty(end)){
      String name = GameDriver.board[end.getX()][end.getY()].getName();
      if(name.equals(" King ")) {
        GameDriver.board[end.getX()][end.getY()] = p;
        this.getState(END).init(getContainer(), this);
        this.enterState(END);
      }
    }
    if (p.getName().equals(" Pawn ")){
      if(((Pawn)p).start.getY() == 1 && (end.getY() == 7)){
        GameDriver.board[end.getX()][end.getY()] = new Queen(end, true, new Image("main/resources/whiteQueen.png"), this);
      }
      else if(((Pawn)p).start.getY() == 6 && (end.getY() == 0)){
        GameDriver.board[end.getX()][end.getY()] = new Queen(end, false, new Image("main/resources/blackQueen.png"), this);
      }
      else{
        GameDriver.board[end.getX()][end.getY()] = p;
      }
      GameDriver.turn = 1 - GameDriver.turn;
      updateValid();
      printBoard();
    }
    else{
      GameDriver.board[end.getX()][end.getY()] = p;
      GameDriver.turn = 1 - GameDriver.turn;
      updateValid();
      printBoard();
    }
  }
  
  public static boolean isEmpty(Position p) {
    return GameDriver.board[p.getX()][p.getY()] == null;
  }
  
  /** .
   * printBoard function
   */
  public static void printBoard() {
    for (int i = 0; i < 8; i++) {
      System.out.print("| ");
      for (int j = 0; j < 8; j++) {
        if (!isEmpty(new Position(j, i))) {
          System.out.print(GameDriver.board[j][i].getName()  + " | ");
        } else {
          System.out.print(" OOOO  | ");
        }
      }
      System.out.println();
    }
  }
  
  /** updateValid function.
   * updates valid moves for each piece
   * 
   */
  public static void updateValid() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (!isEmpty(new Position(j, i))) {
          GameDriver.board[j][i].validMoves();
        }
      }
    }
  }
  
  /** main function.
   * 
   * @param args : Arguments
   */
  public static void main(String[] args) {
    try {
      AppGameContainer container = new AppGameContainer(new GameDriver(GAME));
      container.setDisplayMode(X_SIZE, Y_SIZE, false);
      container.setTargetFrameRate(FPS);
      container.start();
    } catch (SlickException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initStatesList(GameContainer container) throws SlickException {
    this.getState(MENU).init(container, this);
    this.enterState(MENU);
  }

}
