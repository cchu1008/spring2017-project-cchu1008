package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.helper.Position;

public class PositionTest {
  Position p = new Position(0, 0);

  @Test
  public void testConstructor() {
    p = new Position(0, 1);
    assertEquals(0, p.getX());
    assertEquals(1, p.getY());
  }
  
  @Test
  public void testSetXY(){
    p.setX(5);
    p.setY(6);
    
    assertEquals(5, p.getX());
    assertEquals(6, p.getY());
  }
  
  @Test
  public void testSetPosN(){
    Position n = new Position(7, 7);
    p.setPos(n);
    
    assertEquals(n.getX(), p.getX());
    assertEquals(n.getY(), p.getY());
  }
  
  @Test
  public void testSetPosXY(){
    p.setPos(12, 3);
    
    assertEquals(12, p.getX());
    assertEquals(3, p.getY());
  }
  
  @Test
  public void testEquals(){
    Position n = new Position(0, 0);
    Position x = null;
    int y = 7;
    
    assertTrue(p.equals(n));
    assertFalse(p.equals(x));
    assertFalse(p.equals(y));
  }
  
  @Test
  public void testHash(){
    p = new Position(1, 1);
    
    assertEquals(559, p.hashCode());
  }
  
  @Test
  public void testToString(){
    p = new Position(1, 1);
    String s = "(1, 1)";
    
    assertEquals(s, p.toString());
  }

}
