package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Pawn;
import main.piece.Rook;

public class RookTest {
  Rook rook;
  ArrayList<Position> moves = new ArrayList<>();

  @Test
  public void testValidEmptyBoard() {
    GameDriver.clearBoard();
    rook = new Rook(new Position(5, 5), false, ImageType.BLACK_ROOK);
    GameDriver.getBoard()[5][5] = rook;
    
    assertEquals(ImageType.BLACK_ROOK, rook.getImage());
    //Right, Up, Down, Left
    
    moves.add(new Position(6, 5));
    moves.add(new Position(7, 5));
    
    moves.add(new Position(5, 4));
    moves.add(new Position(5, 3));
    moves.add(new Position(5, 2));
    moves.add(new Position(5, 1));
    moves.add(new Position(5, 0));
    
    moves.add(new Position(5, 6));
    moves.add(new Position(5, 7));
    
    moves.add(new Position(4, 5));
    moves.add(new Position(3, 5));
    moves.add(new Position(2, 5));
    moves.add(new Position(1, 5));
    moves.add(new Position(0, 5));
    
    
    assertEquals(moves, (ArrayList<Position>)(rook.getValid()));
  }
  
  @Test
  public void testValidBlocked(){
    GameDriver.clearBoard();
    Pawn blocked = new Pawn(new Position(0, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[0][1] = blocked;
    rook = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    GameDriver.getBoard()[0][0] = rook;
    
    moves.add(new Position(1, 0));
    moves.add(new Position(2, 0));
    moves.add(new Position(3, 0));
    moves.add(new Position(4, 0));
    moves.add(new Position(5, 0));
    moves.add(new Position(6, 0));
    moves.add(new Position(7, 0));
    
    assertEquals(moves, (ArrayList<Position>)(rook.getValid()));
    
  }
  
  @Test
  public void testValidAttack(){
    GameDriver.clearBoard();
    Pawn blocked = new Pawn(new Position(0, 2), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[0][2] = blocked;
    rook = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    GameDriver.getBoard()[0][0] = rook;
    
    moves.add(new Position(1, 0));
    moves.add(new Position(2, 0));
    moves.add(new Position(3, 0));
    moves.add(new Position(4, 0));
    moves.add(new Position(5, 0));
    moves.add(new Position(6, 0));
    moves.add(new Position(7, 0));
    
    moves.add(new Position(0, 1));
    moves.add(new Position(0, 2));
    
    assertEquals(moves, (ArrayList<Position>)(rook.getValid()));
    
    assertTrue(rook.isValid(new Position(3, 0)));
    assertFalse(rook.isValid(new Position(4, 4)));
  }
  
  @Test
  public void testEquals(){
    rook = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    
    assertFalse(rook.equals(null));
    
    Pawn p = new Pawn(new Position(0, 1), false, ImageType.BLACK_PAWN);
    
    assertFalse(rook.equals(p));
    
    Rook r = new Rook(new Position(0, 7), true, ImageType.WHITE_ROOK);
    
    assertFalse(rook.equals(r));
    
    assertTrue(rook.getStart().equals(new Position(0, 0)));
    
    r = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    
    assertTrue(rook.equals(r));
  }

}
