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
  
  @Test
  public void testEquals(){
    assertFalse(move.equals(null));
    
    Position p = new Position(0, 0);
    
    assertFalse(move.equals(p));
    
    Move newMove = new Move(new Position(0, 1), new Position(0, 3));
    
    assertTrue(move.equals(newMove));
    
    newMove = new Move(new Position(3, 4), new Position(3, 5));
    
    assertFalse(move.equals(newMove));
  }

}
