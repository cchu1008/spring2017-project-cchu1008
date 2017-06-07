package main.states;

import main.driver.GameDriver;
import main.driver.Player;
import main.helper.ImageType;
import main.helper.Position;
import main.helper.Tile;
import main.piece.Bishop;
import main.piece.King;
import main.piece.Knight;
import main.piece.Pawn;
import main.piece.Queen;
import main.piece.Rook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Play extends BasicGameState {
  
  public static final int ID = 2;
  private static final HashMap<ImageType, Image> images = new HashMap<>();

  private Player[] players = new Player[2];
  
  private Tile[][] tiles = new Tile[8][8];
  private ArrayList<Position> validMoves;
  private String turnColor;
  
  public Play(){
    //Not sure why we need this
  }
  
  @Override
  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    
    this.players = GameDriver.getPlayers();
    this.validMoves = new ArrayList<Position>();
    
    this.initImages();
    
    generateTiles(container);

    generateWhite();
    generateBlack();

  }

  @Override
  public void render(GameContainer container, StateBasedGame game, 
      Graphics g) throws SlickException {
    
    turnColor = "White";
    
    if(GameDriver.getTurn() == 1){
      turnColor = "Black";
    }
    
    g.setColor(org.newdawn.slick.Color.white);
    g.drawString("Turn: " + turnColor + " (" + GameDriver.getPlayers()[GameDriver.getTurn()].getName() + ")" , GameDriver.X_SIZE * 0.35f, GameDriver.Y_SIZE * 0.03f);
    
    for(int i = 0; i < 8; i++){
      g.drawString("" + (i + 1), GameDriver.X_SIZE * (0.14f + (0.102f * i)), GameDriver.Y_SIZE * 0.073f);
    }
    
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
    for(int i = 0; i < 8; i++){
      g.drawString(letters[i], GameDriver.X_SIZE * 0.04f, GameDriver.Y_SIZE * (0.155f + (0.104f * i)));
    }
    
    
    drawBoard(container, g);
    drawPieces(g);
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int in) throws SlickException {
    //Not sure what to update here.
    checkTiles();
  }

  @Override
  public int getID() {
    return Play.ID;
  }
  
  public static HashMap<ImageType, Image> getImages(){
    return Play.images;
  }
  
  public void initImages(){
    Logger imageLogger = Logger.getLogger("ImageLogger");
    try {
      Play.images.put(ImageType.WHITE_PAWN, new Image("whitePawn.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.WHITE_ROOK, new Image("whiteRook.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.WHITE_KNIGHT, new Image("whiteKnight.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.WHITE_BISHOP, new Image("whiteBishop.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.WHITE_QUEEN, new Image("whiteQueen.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.WHITE_KING, new Image("whiteKing.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    
    try {
      Play.images.put(ImageType.BLACK_PAWN, new Image("blackPawn.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.BLACK_ROOK, new Image("blackRook.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.BLACK_KNIGHT, new Image("blackKnight.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.BLACK_BISHOP, new Image("blackBishop.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.BLACK_QUEEN, new Image("blackQueen.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.BLACK_KING, new Image("blackKing.png"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.DARK_TILE, new Image("darkTile.jpg"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.DARK_TILE_HIGHLIGHTED, new Image("darkTileHighLighted.jpg"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.LIGHT_TILE, new Image("lightTile.jpg"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    try {
      Play.images.put(ImageType.LIGHT_TILE_HIGHLIGHTED, new Image("lightTileHighLighted.jpg"));
    } catch (SlickException e) {
      imageLogger.log(Level.SEVERE, "Bad Image", "");
    }
    
  }
  
  public void lightTiles(ArrayList<Position> valid){
    this.validMoves = valid;
    for(int i = 0; i < valid.size(); i++){
      Position p = valid.get(i);
      this.tiles[p.getX()][p.getY()].mousedOver();
    }
  }
  
  public void checkTiles(){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        this.tiles[j][i].check();
        if(!this.validMoves.contains(new Position(j, i))){
          this.tiles[j][i].reset();
        }
      }
    }
  }
  
  public void resetTiles(){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        this.tiles[j][i].reset();
      }
    }
  }
  
  /** drawBoard function.
   * 
   * @param container : container
   * @param g : graphics
   * @throws SlickException : SlickException
   */
  public void drawBoard(GameContainer container, Graphics g) throws SlickException {
    Image hborder = new Image("border.jpg");
    Image vborder = new Image("borderVerticle.jpg");
    
    for (int i = 1; i < 13; i++) {
      hborder.draw(50f * i, 75, 0.055f);
      hborder.draw(50f * i, 663, 0.055f);
    }
    
    for (int i = 0; i < 12; i++) {
      vborder.draw(50, 75f + (50 * i), 0.055f);
      vborder.draw(638, 75f + (50 * i), 0.055f);
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
            ImageType.DARK_TILE, ImageType.DARK_TILE_HIGHLIGHTED,
            new Position(65 + (143 * (i / 2)), 90 + (143 * (j / 2))), new Position(72, 72), this);
        this.tiles[i + 1][j] = new Tile(i + 1, j, players, container, 
            ImageType.LIGHT_TILE, ImageType.LIGHT_TILE_HIGHLIGHTED,
            new Position(137 + (143 * (i / 2)), 90 + (143 * (j / 2))), new Position(72, 72), this);
        this.tiles[i][j + 1] = new Tile(i, j + 1, players, container, 
            ImageType.LIGHT_TILE, ImageType.LIGHT_TILE_HIGHLIGHTED,
            new Position(65 + (143 * (i / 2)), 162 + (143 * (j / 2))), new Position(72, 72), this);
        this.tiles[i + 1][j + 1] = new Tile(i + 1, j + 1, players, container, 
            ImageType.DARK_TILE, ImageType.DARK_TILE_HIGHLIGHTED,
            new Position(137 + (143 * (i / 2)), 162 + (143 * (j / 2))), new Position(72, 72), this);
      }
    }
  }
  
  /** drawTiles function.
   * 
   * @param container : container
   * @param g : graphics
   * @throws SlickException : SlickException
   */
  public void drawTiles(GameContainer container, Graphics g) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.tiles[i][j].render(container, g);
      }
    }
  }
  
  /** drawPieces function.
   * @param g : graphics
   * 
   * @throws SlickException : SlickException
   */
  public void drawPieces(Graphics g) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (!GameDriver.isEmpty(new Position(i,j))) {
          Play.images.get(GameDriver.getBoard()[i][j].getImage()).draw(tiles[i][j].getX() + 13f, 
              tiles[i][j].getY() + 5f, 0.3f);
        }
      }
    }
  }
  
  /** generateWhite function.
   * 
   * @throws SlickException : SlickException
   */
  public static void generateBlack(){
    for (int i = 0; i < 8; i++) {
      GameDriver.getBoard()[i][1] = new Pawn(new Position(i, 1), false, ImageType.BLACK_PAWN);
    }
    GameDriver.getBoard()[0][0] = new Rook(new Position(0, 0), false, 
        ImageType.BLACK_ROOK);
    GameDriver.getBoard()[7][0] = new Rook(new Position(7, 0), false, 
        ImageType.BLACK_ROOK);
    GameDriver.getBoard()[1][0] = new Knight(new Position(1, 0), false, 
        ImageType.BLACK_KNIGHT);
    GameDriver.getBoard()[6][0] = new Knight(new Position(6, 0), false, 
        ImageType.BLACK_KNIGHT);
    GameDriver.getBoard()[2][0] = new Bishop(new Position(2, 0), false, 
        ImageType.BLACK_BISHOP);
    GameDriver.getBoard()[5][0] = new Bishop(new Position(5, 0), false, 
        ImageType.BLACK_BISHOP);
    GameDriver.getBoard()[3][0] = new Queen(new Position(3, 0), false, 
        ImageType.BLACK_QUEEN);
    GameDriver.getBoard()[4][0] = new King(new Position(4, 0), false, 
        ImageType.BLACK_KING);
  }
  
  /** generateBlack function.
   * 
   * @throws SlickException : SlickException
   */
  public static void generateWhite(){
    for (int i = 0; i < 8; i++) {
      GameDriver.getBoard()[i][6] = new Pawn(new Position(i, 6), true, 
          ImageType.WHITE_PAWN);
    }
    GameDriver.getBoard()[0][7] = new Rook(new Position(0, 7), true, 
        ImageType.WHITE_ROOK);
    GameDriver.getBoard()[7][7] = new Rook(new Position(7, 7), true, 
        ImageType.WHITE_ROOK);
    GameDriver.getBoard()[1][7] = new Knight(new Position(1, 7), true, 
        ImageType.WHITE_KNIGHT);
    GameDriver.getBoard()[6][7] = new Knight(new Position(6, 7), true, 
        ImageType.WHITE_KNIGHT);
    GameDriver.getBoard()[2][7] = new Bishop(new Position(2, 7), true, 
        ImageType.WHITE_BISHOP);
    GameDriver.getBoard()[5][7] = new Bishop(new Position(5, 7), true, 
        ImageType.WHITE_BISHOP);
    GameDriver.getBoard()[3][7] = new Queen(new Position(3, 7), true, 
        ImageType.WHITE_QUEEN);
    GameDriver.getBoard()[4][7] = new King(new Position(4, 7), true, 
        ImageType.WHITE_KING);
    
  }

}
