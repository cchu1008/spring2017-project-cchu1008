package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Pawn;

public class PawnTest {
  Pawn p;
  ArrayList<Position> moves = new ArrayList<>();

  @Test
  public void testValidMovesCleanBoard() {
    GameDriver.clearBoard();
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.board[2][1] = p;
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.board[2][6] = p;
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 5));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
  }
  
  @Test
  public void testValidBlocked(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(2, 2), true, ImageType.WHITE_PAWN);
    GameDriver.board[2][2] = blocker;
    
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.board[2][1] = p;
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    blocker = new Pawn(new Position(2, 5), false, ImageType.BLACK_PAWN);
    GameDriver.board[2][5] = blocker;
    
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.board[2][6] = p;
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
  }
  
  @Test public void testValidAttack(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(3, 2), true, ImageType.WHITE_PAWN);
    GameDriver.board[3][2] = blocker;
    
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.board[2][1] = p;
    
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));
    moves.add(new Position(3, 2));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    blocker = new Pawn(new Position(3, 5), false, ImageType.BLACK_PAWN);
    GameDriver.board[3][5] = blocker;
    
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.board[2][6] = p;
    
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 5));
    moves.add(new Position(3, 5));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
  }
  
  @Test
  public void testValidAttackLeft(){
    GameDriver.clearBoard();
    Pawn blocker = new Pawn(new Position(1, 2), true, ImageType.WHITE_PAWN);
    GameDriver.board[1][2] = blocker;
    
    p = new Pawn(new Position(2, 1), false, ImageType.BLACK_PAWN);
    GameDriver.board[2][1] = p;
    
    moves.add(new Position(2, 3));
    moves.add(new Position(2, 2));
    moves.add(new Position(1, 2));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
    
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    blocker = new Pawn(new Position(1, 5), false, ImageType.BLACK_PAWN);
    GameDriver.board[1][5] = blocker;
    
    p = new Pawn(new Position(2, 6), true, ImageType.WHITE_PAWN);
    GameDriver.board[2][6] = p;
    
    moves.add(new Position(2, 4));
    moves.add(new Position(2, 5));
    moves.add(new Position(1, 5));
    
    assertEquals(moves, (ArrayList<Position>)(p.getValid()));
  }
  
  @Test
  public void testPieceHash(){
    p = new Pawn(new Position(1, 1), false, ImageType.BLACK_PAWN);
    assertEquals(7267, p.hashCode());
  }

}
