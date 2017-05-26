package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.driver.GameDriver;
import main.driver.Menu;
import main.driver.Play;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Bishop;
import main.piece.King;
import main.piece.Knight;
import main.piece.Pawn;
import main.piece.Piece;
import main.piece.Queen;
import main.piece.Rook;

public class GameDriverTest {

  @Test
  public void testAdvanceTurn(){    
    Menu.type = false;
    GameDriver.turn = 0;
    
    GameDriver.advanceTurn();
    
    assertEquals(1, GameDriver.turn);
  }

  @Test
  public void testEmptySpace(){
    GameDriver.clearBoard();
    GameDriver.board[0][3] = null;
    assertEquals(true, GameDriver.isEmpty(new Position(0, 3)));
  }
  
  @Test
  public void testPawnQueening(){
    GameDriver.clearBoard();
    GameDriver.board[2][1] = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    Pawn p = (Pawn)(GameDriver.board[2][1]);
    
    GameDriver.board[2][1] = null;
    GameDriver.board[2][5] = p;
    
    p.move(new Position(2, 5));
    GameDriver.pawnQueening((Pawn) GameDriver.board[2][5], new Position(2, 6));

    assertEquals(Pawn.class, GameDriver.board[2][6].getClass());
    
    GameDriver.pawnQueening(p, new Position(2, 7));
    
    assertEquals(Queen.class, GameDriver.board[2][7].getClass());
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
        if(compare[i][j] != null && GameDriver.board[i][j] != null){
          assertEquals(compare[i][j].getName(), GameDriver.board[i][j].getName());
          assertEquals(compare[i][j].getLocation(), GameDriver.board[i][j].getLocation());
          assertEquals(compare[i][j].isWhite(), GameDriver.board[i][j].isWhite());
        }
        else {
          assertTrue(compare[i][j] == null && GameDriver.board[i][j] == null);
        }
      }
    }
    
    boolean reportNotEquals = compare[0][0].equals(GameDriver.board[5][1]);
    assertFalse(reportNotEquals);
    
  }

}
