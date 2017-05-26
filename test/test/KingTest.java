package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.King;
import main.piece.Pawn;

public class KingTest {
  King king;
  ArrayList<Position> moves = new ArrayList<>();

  @Test
  public void testValidClearBoard() {
    GameDriver.clearBoard();
    king = new King(new Position(3, 3), false, ImageType.BLACK_KING);
    GameDriver.board[3][3] = king;
    assertEquals(ImageType.BLACK_KING, king.getImage());
    

    moves.add(new Position(2, 4));
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));

    moves.add(new Position(3, 4));
    moves.add(new Position(3, 2));

    moves.add(new Position(4, 4));
    moves.add(new Position(4, 3));
    moves.add(new Position(4, 2));
    
    assertEquals(moves, (ArrayList<Position>)(king.getValid()));

  }
  
  @Test
  public void testValidBlocked(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(2, 4), false, ImageType.BLACK_PAWN);
    GameDriver.board[2][4] = blocker;
    king = new King(new Position(3, 3), false, ImageType.BLACK_KING);
    GameDriver.board[3][3] = king;
    
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));

    moves.add(new Position(3, 4));
    moves.add(new Position(3, 2));

    moves.add(new Position(4, 4));
    moves.add(new Position(4, 3));
    moves.add(new Position(4, 2));
    
    assertEquals(moves, (ArrayList<Position>)(king.getValid()));
    
  }
  
  @Test
  public void testValidAttack(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(2, 4), true, ImageType.WHITE_PAWN);
    GameDriver.board[2][4] = blocker;
    king = new King(new Position(3, 3), false, ImageType.BLACK_KING);
    GameDriver.board[3][3] = king;
    
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));

    moves.add(new Position(3, 4));
    moves.add(new Position(3, 2));

    moves.add(new Position(4, 4));
    moves.add(new Position(4, 3));
    moves.add(new Position(4, 2));
    
    assertEquals(moves, (ArrayList<Position>)(king.getValid()));
  }

}
