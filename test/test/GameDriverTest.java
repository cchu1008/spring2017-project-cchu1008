package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.driver.GameDriver;
import main.driver.Menu;
import main.helper.ImageType;
import main.helper.Position;
import main.piece.Pawn;
import main.piece.Queen;

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
    GameDriver.board[0][3] = null;
    assertEquals(true, GameDriver.isEmpty(new Position(0, 3)));
  }
  
  @Test
  public void testPawnQueening(){
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

}
