package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.helper.Position;

public class PositionTest {

  @Test
  public void test() {
    Position p = new Position(0, 1);
    assertEquals(0, p.getX());
    assertEquals(1, p.getY());
  }

}
