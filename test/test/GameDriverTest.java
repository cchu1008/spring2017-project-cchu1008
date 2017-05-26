package test;

import static org.junit.Assert.*;


import org.junit.Test;

import main.driver.GameDriver;
import main.driver.Menu;
import main.helper.Position;

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

}
