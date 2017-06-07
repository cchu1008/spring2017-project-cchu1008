package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Knight;
import main.piece.Pawn;

public class KnightTest {
  Knight knight;
  ArrayList<Position> moves = new ArrayList<>();

  @Test
  public void testValidClear() {
    GameDriver.clearBoard();
    knight = new Knight(new Position(3, 3), false, ImageType.BLACK_KNIGHT);
    GameDriver.getBoard()[3][3] = knight;
    
    assertEquals(ImageType.BLACK_KNIGHT, knight.getImage());
    
    moves.add(new Position(2, 5));
    moves.add(new Position(2, 1));
    
    moves.add(new Position(5, 2));
    moves.add(new Position(1, 2));
    
    moves.add(new Position(4, 5));
    moves.add(new Position(4, 1));
    
    moves.add(new Position(5, 4));
    moves.add(new Position(1, 4));
    
    assertEquals(moves, (ArrayList<Position>)(knight.getValid()));
    
  }
  
  @Test
  public void testValidBlocked() {
    GameDriver.clearBoard();
    Pawn p = new Pawn(new Position(2, 5), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][5] = p;
    Pawn p1 = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[2][1] = p1;
    
    Pawn p2 = new Pawn(new Position(5, 2), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[5][2] = p2;
    Pawn p3 = new Pawn(new Position(1, 2), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[1][2] = p3;
    
    Pawn p4 = new Pawn(new Position(4, 5), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[4][5] = p4;
    Pawn p5 = new Pawn(new Position(4, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[4][1] = p5;
    
    Pawn p6 = new Pawn(new Position(5, 4), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[5][4] = p6;
    Pawn p7 = new Pawn(new Position(1, 4), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[1][4] = p7;
    
    knight = new Knight(new Position(3, 3), false, ImageType.BLACK_KNIGHT);
    GameDriver.getBoard()[3][3] = knight;
    
    assertEquals(moves, (ArrayList<Position>)(knight.getValid()));
  }
  
  @Test
  public void testValidAttack(){
    GameDriver.clearBoard();
    Pawn p = new Pawn(new Position(2, 5), true, ImageType.WHITE_PAWN);
    GameDriver.getBoard()[2][5] = p;
    knight = new Knight(new Position(3, 3), false, ImageType.BLACK_KNIGHT);
    GameDriver.getBoard()[3][3] = knight;
    
    moves.add(new Position(2, 5));
    moves.add(new Position(2, 1));
    
    moves.add(new Position(5, 2));
    moves.add(new Position(1, 2));
    
    moves.add(new Position(4, 5));
    moves.add(new Position(4, 1));
    
    moves.add(new Position(5, 4));
    moves.add(new Position(1, 4));
    
    assertEquals(moves, (ArrayList<Position>)(knight.getValid()));
  }
  
  @Test
  public void testValidOffBoard(){
    GameDriver.clearBoard();
    knight = new Knight(new Position(2, 0), false, ImageType.BLACK_KNIGHT);
    
    moves.add(new Position(1, 2));
    moves.add(new Position(3, 2));
    
    moves.add(new Position(4, 1));
    moves.add(new Position(0, 1));
    
    assertEquals(moves, (ArrayList<Position>)(knight.getValid()));
    
  }
  
  @Test
  public void testEquals(){
    GameDriver.clearBoard();
    knight = new Knight(new Position(2, 0), false, ImageType.BLACK_KNIGHT);
    
    assertFalse(knight.equals(null));
    
    Pawn p = new Pawn(new Position(0, 1), false, ImageType.BLACK_KNIGHT);
    
    assertFalse(knight.equals(p));
    
    Knight newKnight = new Knight(new Position(5, 0), false, ImageType.BLACK_KNIGHT);
    
    assertFalse(knight.equals(newKnight));
  }

}
