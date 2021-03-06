package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Bishop;
import main.piece.King;
import main.piece.Knight;
import main.piece.Pawn;
import main.piece.Piece;
import main.piece.Queen;
import main.piece.Rook;
import main.states.Menu;
import main.states.Play;

public class GameDriverTest {
  
  @Test
  public void testGameDriver(){
    GameDriver game = new GameDriver("Chess");
    
    assertEquals("Chess", game.getTitle());
    
    GameDriver.setPlayers(null, null);
    
    assertEquals(null, GameDriver.getPlayers()[0]);
    assertEquals(null, GameDriver.getPlayers()[1]);
  }

  @Test
  public void testAdvanceTurn(){    
    Menu.setType(false);
    GameDriver.setTurn(0);
    
    GameDriver.advanceTurn();
    
    assertEquals(1, GameDriver.getTurn());
  }

  @Test
  public void testEmptySpace(){
    GameDriver.clearBoard();
    GameDriver.getBoard()[0][3] = null;
    assertEquals(true, GameDriver.isEmpty(new Position(0, 3)));
  }
  
  @Test
  public void testPawnQueeningBlack(){
    GameDriver.clearBoard();
    GameDriver.getBoard()[2][1] = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    Pawn p = (Pawn)(GameDriver.getBoard()[2][1]);
    
    GameDriver.getBoard()[2][1] = null;
    GameDriver.getBoard()[2][5] = p;
    
    p.move(new Position(2, 5));
    GameDriver.pawnQueening((Pawn) GameDriver.getBoard()[2][5], new Position(2, 6));

    assertEquals(Pawn.class, GameDriver.getBoard()[2][6].getClass());
    
    GameDriver.pawnQueening(p, new Position(2, 7));
    
    assertEquals(Queen.class, GameDriver.getBoard()[2][7].getClass());
    
    GameDriver.clearBoard();
    GameDriver.getBoard()[2][2] = new Pawn(new Position(2, 2), false, ImageType.BLACK_PAWN);
    p = (Pawn)(GameDriver.getBoard()[2][2]);
    
    GameDriver.getBoard()[2][2] = null;
    GameDriver.getBoard()[2][5] = p;
    
    p.move(new Position(2, 5));
    GameDriver.pawnQueening((Pawn) GameDriver.getBoard()[2][5], new Position(2, 6));

    assertEquals(Pawn.class, GameDriver.getBoard()[2][6].getClass());
    
    GameDriver.pawnQueening(p, new Position(2, 7));
    
    assertEquals(Pawn.class, GameDriver.getBoard()[2][7].getClass());
  }
  
  @Test
  public void testPawnQueeningWhite(){
    GameDriver.clearBoard();
    GameDriver.getBoard()[2][6] = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    Pawn p = (Pawn)(GameDriver.getBoard()[2][6]);
    
    GameDriver.getBoard()[2][6] = null;
    GameDriver.getBoard()[2][2] = p;
    
    p.move(new Position(2, 2));
    GameDriver.pawnQueening((Pawn) GameDriver.getBoard()[2][2], new Position(2, 1));

    assertEquals(Pawn.class, GameDriver.getBoard()[2][1].getClass());
    
    GameDriver.pawnQueening(p, new Position(2, 0));
    
    assertEquals(Queen.class, GameDriver.getBoard()[2][0].getClass());
    
    GameDriver.clearBoard();
    GameDriver.getBoard()[2][5] = new Pawn(new Position(2, 5), false, ImageType.WHITE_PAWN);
    p = (Pawn)(GameDriver.getBoard()[2][5]);
    
    GameDriver.getBoard()[2][5] = null;
    GameDriver.getBoard()[2][2] = p;
    
    p.move(new Position(2, 2));
    GameDriver.pawnQueening((Pawn) GameDriver.getBoard()[2][2], new Position(2, 1));

    assertEquals(Pawn.class, GameDriver.getBoard()[2][1].getClass());
    
    GameDriver.pawnQueening(p, new Position(2, 0));
    
    assertEquals(Pawn.class, GameDriver.getBoard()[2][0].getClass());
  }
  
  @Test
  public void testPopulateBoard(){
    GameDriver.clearBoard();
    Piece[][] compare = new Piece[8][8];
    
    for(int i = 0; i < 8; i++){
      compare[i][1] = new Pawn(new Position(i, 1), false, ImageType.BLACK_PAWN);
      compare[i][6] = new Pawn(new Position(i, 6), true, ImageType.WHITE_PAWN);
    }
    
    compare[0][0] = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    compare[7][0] = new Rook(new Position(7, 0), false, ImageType.BLACK_ROOK);
    
    compare[0][7] = new Rook(new Position(0, 7), true, ImageType.WHITE_ROOK);
    compare[7][7] = new Rook(new Position(7, 7), true, ImageType.WHITE_ROOK);
    
    
    compare[1][0] = new Knight(new Position(1, 0), false, ImageType.BLACK_KNIGHT);
    compare[6][0] = new Knight(new Position(6, 0), false, ImageType.BLACK_KNIGHT);
    
    compare[1][7] = new Knight(new Position(1, 7), true, ImageType.WHITE_KNIGHT);
    compare[6][7] = new Knight(new Position(6, 7), true, ImageType.WHITE_KNIGHT);
    
    compare[2][0] = new Bishop(new Position(2, 0), false, ImageType.BLACK_BISHOP);
    compare[5][0] = new Bishop(new Position(5, 0), false, ImageType.BLACK_BISHOP);
    
    compare[2][7] = new Bishop(new Position(2, 7), true, ImageType.WHITE_BISHOP);
    compare[5][7] = new Bishop(new Position(5, 7), true, ImageType.WHITE_BISHOP);
    
    compare[3][0] = new Queen(new Position(3, 0), false, ImageType.BLACK_QUEEN);
    compare[4][0] = new King(new Position(4, 0), false, ImageType.BLACK_KING);
    
    compare[3][7] = new Queen(new Position(3, 7), true, ImageType.WHITE_QUEEN);
    compare[4][7] = new King(new Position(4, 7), true, ImageType.WHITE_KING);
    
    Play.generateWhite();
    Play.generateBlack();
    
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        if(compare[i][j] != null && GameDriver.getBoard()[i][j] != null){
          assertEquals(compare[i][j].getName(), GameDriver.getBoard()[i][j].getName());
          assertEquals(compare[i][j].getLocation(), GameDriver.getBoard()[i][j].getLocation());
          assertEquals(compare[i][j].isWhite(), GameDriver.getBoard()[i][j].isWhite());
        }
        else {
          assertTrue(compare[i][j] == null && GameDriver.getBoard()[i][j] == null);
        }
      }
    }
    
    boolean reportNotEquals = compare[0][0].equals(GameDriver.getBoard()[5][1]);
    assertFalse(reportNotEquals);
    
  }


}
