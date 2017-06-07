package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Knight;
import main.piece.Pawn;

public class PawnTest {
  Pawn p;
  ArrayList<Position> moves = new ArrayList<>();

  @Test
  public void testValidMovesCleanBoard() {
    GameDriver.clearBoard();
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][1] = p;
    
    assertEquals(ImageType.BLACK_PAWN, p.getImage());
    
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[2][6] = p;
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 5));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
  }
  
  @Test
  public void testValidBlocked(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(2, 2), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[2][2] = blocker;
    
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][1] = p;
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    blocker = new Pawn(new Position(2, 5), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][5] = blocker;
    
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[2][6] = p;
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
  }
  
  @Test public void testValidAttack(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(3, 2), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[3][2] = blocker;
    
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][1] = p;
    
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));
    moves.add(new Position(3, 2));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    blocker = new Pawn(new Position(3, 5), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[3][5] = blocker;
    
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[2][6] = p;
    
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 5));
    moves.add(new Position(3, 5));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
  }
  
  @Test
  public void testValidAttackLeft(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(1, 2), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[1][2] = blocker;
    
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][1] = p;
    
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));
    moves.add(new Position(1, 2));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    blocker = new Pawn(new Position(1, 5), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[1][5] = blocker;
    
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[2][6] = p;
    
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 5));
    moves.add(new Position(1, 5));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
  }
  
  @Test
  public void testPieceHash(){
    p = new Pawn(new Position(1, 1), false, ImageType.BLACK_PAWN);
    assertEquals(7826, p.hashCode());
    
    p = new Pawn(new Position(1, 2), true, ImageType.WHITE_PAWN);
    assertEquals(7841, p.hashCode());
  }
  
  @Test
  public void testNullPiece(){
    p = null;
    Pawn blocker = new Pawn(new Position(1, 1), false, ImageType.BLACK_PAWN);
    
    assertFalse(blocker.equals(p));
  }
  
  @Test
  public void testEqualsNonNull(){
    p = new Pawn(new Position(1, 1), false, ImageType.BLACK_PAWN);
    Pawn otherPawn = new Pawn(new Position(1, 6), true, ImageType.WHITE_PAWN);
    
    assertFalse(otherPawn.equals(p));
    
    assertFalse(otherPawn.equals(null));
    
    Pawn sameColor = new Pawn(new Position(2, 0), false, ImageType.BLACK_PAWN);
    
    assertFalse(sameColor.equals(p));
    
    Knight k = new Knight(new Position(1, 2), false, ImageType.BLACK_KNIGHT);
    
    assertFalse(p.equals(k));
    
    otherPawn = new Pawn(new Position(1, 1), false, ImageType.BLACK_PAWN);
    
    assertTrue(p.equals(otherPawn));
  }

}
