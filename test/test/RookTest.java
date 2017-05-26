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
    GameDriver.board[5][5] = rook;
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
    GameDriver.board[0][1] = blocked;
    rook = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    GameDriver.board[0][0] = rook;
    
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
    GameDriver.board[0][2] = blocked;
    rook = new Rook(new Position(0, 0), false, ImageType.BLACK_ROOK);
    GameDriver.board[0][0] = rook;
    
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
  }

}
