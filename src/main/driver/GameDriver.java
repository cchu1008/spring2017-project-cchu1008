package main.driver;

import main.helper.ImageType;
import main.helper.Position;
import main.piece.Pawn;
import main.piece.Piece;
import main.piece.Queen;
import main.states.End;
import main.states.Menu;
import main.states.Play;
import main.states.Setup;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameDriver extends StateBasedGame {
  public static final String GAME = "Chess";
  public static final int MENU = 0;
  public static final int SETUP = 1;
  public static final int PLAY = 2;
  public static final int END = 3;
  public static final int FPS = 300;
  public static final int X_SIZE = 700;
  public static final int Y_SIZE = 700;
  
  private static Piece[][] board = new Piece[8][8];
  private static Player[] players = new Player[2];
  
  private static int turn = 0;
  
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
  
  public static Piece[][] getBoard() {
    return GameDriver.board;
  }
  
  public static Player[] getPlayers() {
    return GameDriver.players;
  }
  
  public static int getTurn() {
    return GameDriver.turn;
  }
  
  public static void setTurn(int i) {
    GameDriver.turn = i;
  }
  
  /** Move Function.
   * 
   * @param start : Start position
   * @param end : End position
   * @param game : game
   * @param container : container
   * @throws SlickException : Throws slick exception
   */
  public static void move(Position start, Position end, StateBasedGame game, GameContainer container) throws SlickException {
    Piece p = board[start.getX()][start.getY()];
    board[start.getX()][start.getY()] = null;
    p.move(end);
    if (!GameDriver.isEmpty(end)){
      String name = board[end.getX()][end.getY()].getName();
      if(name.equals(" King ")) {
        board[end.getX()][end.getY()] = p;
        ((GameDriver)game).createState(container, End.ID);
      }
    }
    if (p.getName().equals(" Pawn ")){
      pawnQueening((Pawn)p, end);
      advanceTurn();
    }
    else{
      board[end.getX()][end.getY()] = p;
      advanceTurn();
    }
  }
  
  public static void advanceTurn(){
    Logger moveDebug = Logger.getLogger("MoveDebug");
    turn = 1 - turn;
    moveDebug.log(Level.INFO, "CPU Game: " + Menu.getType() + "Turn: " + turn, "");
    if(Menu.getType() && turn == 1){
      GameDriver.players[1].movePiece();
    }
    updateValid();
    printBoard();
  }
  
  public static void pawnQueening(Pawn p, Position end){
    if(((Pawn)p).getStart().getY() == 1 && (end.getY() == 7)){
      board[end.getX()][end.getY()] = new Queen(end, false, ImageType.BLACK_QUEEN);
    }
    else if(((Pawn)p).getStart().getY() == 6 && (end.getY() == 0)){
      board[end.getX()][end.getY()] = new Queen(end, true, ImageType.WHITE_QUEEN);
    }
    else{
      board[end.getX()][end.getY()] = p;
    }
  }
  
  public static void setPlayers(Player one, Player two){
    players[0] = one;
    players[1] = two;
  }
  
  public static boolean isEmpty(Position p) {
    return GameDriver.board[p.getX()][p.getY()] == null;
  }
  
  public static void clearBoard(){
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        GameDriver.board[i][j] = null;
      }
    }
  }
  
  public void lightUpValid(GameState play, Position pos){
    if(!GameDriver.isEmpty(pos)){
      ArrayList<Position> valid = (ArrayList<Position>)board[pos.getX()][pos.getY()].getValid();
      valid.add(0, pos);
      ((Play)play).lightTiles(valid);
    }
    else {
      ((Play)play).lightTiles(new ArrayList<Position>());
    }
  }
  
  /** .
   * printBoard function
   */
  public static void printBoard() {
    Logger boardLogger = Logger.getLogger("BoardLogger");
    String fin = "\n";
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (!isEmpty(new Position(j, i))) {
          fin += GameDriver.board[j][i].getName()  + " | ";
        } else {
          fin += " OOOO  | ";
        }
      }
      fin += "\n";
    }
    
    boardLogger.log(Level.INFO, fin, "");
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
    } catch (SlickException ex) {
      Logger.getLogger("ContainerLogger").log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void initStatesList(GameContainer container) throws SlickException {
    this.getState(MENU).init(container, this);
    this.enterState(MENU);
  }
  
  public void createState(GameContainer container, int id){
    try {
      this.getState(id).init(container, this);
    } catch (SlickException ex) {
      Logger.getLogger("StateLogger").log(Level.SEVERE, null, ex);
    }
    this.enterState(id);
  }

}
