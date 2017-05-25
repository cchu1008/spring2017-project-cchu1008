package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.helper.Move;
import main.helper.Position;

public class MoveTest {

  Move move = new Move(new Position(0, 1), new Position(0, 3));
  
  @Test
  public void testGetStart(){
    assertEquals(new Position(0, 1), this.move.getStart());
  }
  
  @Test
  public void testGetEnd(){
    assertEquals(new Position(0, 3), this.move.getEnd());
  }

}
