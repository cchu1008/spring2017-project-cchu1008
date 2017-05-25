package test;

import static org.junit.Assert.*;


import org.junit.Test;

import main.driver.GameDriver;
import main.driver.Menu;

public class GameDriverTest {

  @Test
  public void testAdvanceTurn(){    
    Menu.type = false;
    GameDriver.turn = 0;
    
    GameDriver.advanceTurn();
    
    assertEquals(1, GameDriver.turn);
    
  }

}
