package main.driver;

import main.helper.Position;

import main.piece.Bishop;
import main.piece.King;
import main.piece.Knight;
import main.piece.Pawn;
import main.piece.Queen;
import main.piece.Rook;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Play extends BasicGameState {
  
  public static final int ID = 2;

  private GameDriver game;
  private Player[] players = new Player[2];
  
  private Tile[][] tiles = new Tile[8][8];
  
  public Play(){
    //Not sure why we need this
  }
  
  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    
    this.game = (GameDriver)game;
    this.players = ((GameDriver)game).players;
    
    generateTiles(container);

    generateWhite();
    generateBlack();

  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    
    g.setColor(Color.red);
    g.drawString("This is the Play State", GameDriver.X_SIZE * 0.360f, GameDriver.Y_SIZE / 8f);
    g.setColor(Color.white);
    g.drawString("State Based Game Test", GameDriver.X_SIZE * 0.365f, GameDriver.Y_SIZE / 6f);
    g.drawString("Numbers 0-3 will switch between states.", 
        GameDriver.X_SIZE * 0.255f, GameDriver.Y_SIZE / 4f);

    g.drawString("Player 1: ", GameDriver.X_SIZE / 3f, GameDriver.Y_SIZE / 3f);
    g.drawString(((GameDriver)game).players[0].getName(), 
        (GameDriver.X_SIZE / 3f + 100f), GameDriver.Y_SIZE / 3f);
    g.drawString("Player 2: ", GameDriver.X_SIZE / 3f, GameDriver.Y_SIZE / 2f);
    g.drawString(((GameDriver)game).players[1].getName(), 
        GameDriver.X_SIZE / 3f + 100f, GameDriver.Y_SIZE / 2f);
    
    drawBoard(container, g);
    drawPieces(container, g);
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int in) throws SlickException {
    //Not sure what to update here.
  }

  @Override
  public int getID() {
    return Play.ID;
  }
  
  /** keyReleased function.
   * 
   */
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_RIGHT || key == Input.KEY_3) {
      this.game.getState(End.ID);
      this.game.enterState(End.ID);
    }
    if (key == Input.KEY_LEFT || key == Input.KEY_1) {
      this.game.getState(Setup.ID);
      this.game.enterState(Setup.ID);
    }
    if (key == Input.KEY_0) {
      this.game.getState(Menu.ID);
      this.game.enterState(Menu.ID);
    }
  }
  
  /** drawBoard function.
   * 
   * @param container : container
   * @param g : graphics
   * @throws SlickException : SlickException
   */
  public void drawBoard(GameContainer container, Graphics g) throws SlickException {
    Image hborder = new Image("main/resources/border.jpg");
    Image vborder = new Image("main/resources/borderVerticle.jpg");
    
    for (int i = 1; i < 13; i++) {
      hborder.draw(50f * i, 15, 0.055f);
      hborder.draw(50f * i, 603, 0.055f);
    }
    
    for (int i = 0; i < 12; i++) {
      vborder.draw(50, 15f + (50 * i), 0.055f);
      vborder.draw(638, 15f + (50 * i), 0.055f);
    }
    
    drawTiles(container, g);
  }
  
  /** generateTiles function.
   * 
   * @param container : container
   * @throws SlickException : SlickException
   */
  public void generateTiles(GameContainer container) throws SlickException {
    for (int j = 0; j < 8; j += 2) {
      for (int i = 0; i < 8; i += 2) {
        this.tiles[i][j] = new Tile(i, j, players, container, 
            new Image("main/resources/darkTile.jpg"), 
            65 + (143 * (i / 2)), 30 + (143 * (j / 2)), 72, 72);
        this.tiles[i][j].setMouseOverImage(new Image("main/resources/darkTileHighlighted.jpg"));
        this.tiles[i + 1][j] = new Tile(i + 1, j, players, container, 
            new Image("main/resources/lightTile.jpg"), 
            137 + (143 * (i / 2)), 30 + (143 * (j / 2)), 72, 72);
        this.tiles[i + 1][j].setMouseOverImage(
            new Image("main/resources/lightTileHighlighted.jpg"));
        this.tiles[i][j + 1] = new Tile(i, j + 1, players, container, 
            new Image("main/resources/lightTile.jpg"), 
            65 + (143 * (i / 2)), 102 + (143 * (j / 2)), 72, 72);
        this.tiles[i][j + 1].setMouseOverImage(
            new Image("main/resources/lightTileHighlighted.jpg"));
        this.tiles[i + 1][j + 1] = new Tile(i + 1, j + 1, players, container, 
            new Image("main/resources/darkTile.jpg"), 
            137 + (143 * (i / 2)), 102 + (143 * (j / 2)), 72, 72);
        this.tiles[i + 1][j + 1].setMouseOverImage(
            new Image("main/resources/darkTileHighlighted.jpg"));
      }
    }
  }
  
  /** drawTiles function.
   * 
   * @param container : container
   * @param g : graphics
   * @throws SlickException : SlickException
   */
  public void drawTiles(GameContainer container, Graphics g) throws SlickException {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.tiles[i][j].render(container, g);
      }
    }
  }
  
  /** drawPieces function.
   * 
   * @param container : container
   * @param g : graphics
   * @throws SlickException : SlickException
   */
  public void drawPieces(GameContainer container, Graphics g) throws SlickException {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (!GameDriver.isEmpty(new Position(i,j))) {
          GameDriver.board[i][j].getImage().draw(tiles[i][j].getX() + 13f, 
              tiles[i][j].getY() + 5f, 0.3f);
        }
      }
    }
  }
  
  /** generateWhite function.
   * 
   * @throws SlickException : SlickException
   */
  public void generateWhite(){
    for (int i = 0; i < 8; i++) {
      try {
        GameDriver.board[i][1] = new Pawn(new Position(i, 1), true, 
            new Image("main/resources/whitePawn.png"));
      } catch (SlickException e) {
        e.printStackTrace();
      }
    }
    try {
      GameDriver.board[0][0] = new Rook(new Position(0, 0), true, 
          new Image("main/resources/whiteRook.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[7][0] = new Rook(new Position(7, 0), true, 
          new Image("main/resources/whiteRook.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[1][0] = new Knight(new Position(1, 0), true, 
          new Image("main/resources/whiteKnight.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[6][0] = new Knight(new Position(6, 0), true, 
          new Image("main/resources/whiteKnight.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[2][0] = new Bishop(new Position(2, 0), true, 
          new Image("main/resources/whiteBishop.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[5][0] = new Bishop(new Position(5, 0), true, 
          new Image("main/resources/whiteBishop.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[3][0] = new Queen(new Position(3, 0), true, 
          new Image("main/resources/whiteQueen.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[4][0] = new King(new Position(4, 0), true, 
          new Image("main/resources/whiteKing.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
  }
  
  /** generateBlack function.
   * 
   * @throws SlickException : SlickException
   */
  public void generateBlack(){
    for (int i = 0; i < 8; i++) {
      try {
        GameDriver.board[i][6] = new Pawn(new Position(i, 6), false, 
            new Image("main/resources/blackPawn.png"));
      } catch (SlickException e) {
        e.printStackTrace();
      }
    }
    try {
      GameDriver.board[0][7] = new Rook(new Position(0, 7), false, 
          new Image("main/resources/blackRook.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[7][7] = new Rook(new Position(7, 7), false, 
          new Image("main/resources/blackRook.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[1][7] = new Knight(new Position(1, 7), false, 
          new Image("main/resources/blackKnight.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[6][7] = new Knight(new Position(6, 7), false, 
          new Image("main/resources/blackKnight.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[2][7] = new Bishop(new Position(2, 7), false, 
          new Image("main/resources/blackBishop.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[5][7] = new Bishop(new Position(5, 7), false, 
          new Image("main/resources/blackBishop.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[3][7] = new Queen(new Position(3, 7), false, 
          new Image("main/resources/blackQueen.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    try {
      GameDriver.board[4][7] = new King(new Position(4, 7), false, 
          new Image("main/resources/blackKing.png"));
    } catch (SlickException e) {
      e.printStackTrace();
    }
    
  }

}
