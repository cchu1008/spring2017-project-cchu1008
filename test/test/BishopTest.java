package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Bishop;
import main.piece.Rook;

public class BishopTest {
  Bishop bishop;
  ArrayList<Position> moves = new ArrayList<>();
  
  
  @Test
  public void testValidEmpty() {
    GameDriver.clearBoard();
    bishop = new Bishop(new Position(3, 3), false, ImageType.BLACK_BISHOP);
    GameDriver.board[3][3] = bishop;
    
    //UP right, left
    //Down right, left
    
    moves.add(new Position(4, 2));
    moves.add(new Position(5, 1));
    moves.add(new Position(6, 0));
    
    moves.add(new Position(2, 2));
    moves.add(new Position(1, 1));
    moves.add(new Position(0, 0));
    
    moves.add(new Position(4, 4));
    moves.add(new Position(5, 5));
    moves.add(new Position(6, 6));
    moves.add(new Position(7, 7));
    
    moves.add(new Position(2, 4));
    moves.add(new Position(1, 5));
    moves.add(new Position(0, 6));
    
    
    assertEquals(moves, (ArrayList<Position>)(bishop.getValid()));
  }
  
  @Test
  public void testValidBlocked(){
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    Rook blocker = new Rook(new Position(4, 2), false, ImageType.BLACK_ROOK);
    GameDriver.board[4][2] = blocker;
    
    bishop = new Bishop(new Position(3, 3), false, ImageType.BLACK_BISHOP);
    GameDriver.board[3][3] = bishop;
    
    moves.add(new Position(2, 2));
    moves.add(new Position(1, 1));
    moves.add(new Position(0, 0));
    
    moves.add(new Position(4, 4));
    moves.add(new Position(5, 5));
    moves.add(new Position(6, 6));
    moves.add(new Position(7, 7));
    
    moves.add(new Position(2, 4));
    moves.add(new Position(1, 5));
    moves.add(new Position(0, 6));
    
    assertEquals(moves, (ArrayList<Position>)(bishop.getValid()));
    
  }

  @Test
  public void testValidAttack(){
    GameDriver.clearBoard();
    moves = new ArrayList<Position>();
    Rook blocker = new Rook(new Position(4, 2), true, ImageType.WHITE_ROOK);
    GameDriver.board[4][2] = blocker;
    
    bishop = new Bishop(new Position(3, 3), false, ImageType.BLACK_BISHOP);
    GameDriver.board[3][3] = bishop;
    
    moves.add(new Position(4, 2));
    
    moves.add(new Position(2, 2));
    moves.add(new Position(1, 1));
    moves.add(new Position(0, 0));
    
    moves.add(new Position(4, 4));
    moves.add(new Position(5, 5));
    moves.add(new Position(6, 6));
    moves.add(new Position(7, 7));
    
    moves.add(new Position(2, 4));
    moves.add(new Position(1, 5));
    moves.add(new Position(0, 6));
    
    assertEquals(moves, (ArrayList<Position>)(bishop.getValid()));
  }
}
