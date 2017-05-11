package test;


import junit.framework.TestCase;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


import main.driver.GameDriver;
import main.helper.Position;
import main.piece.Pawn;

public class PawnTest extends TestCase {    
  public GameDriver game = new GameDriver("Chess");
  public Pawn pawn;

  @Test
  public void testConstructor() {
    
    try{
      Display.setDisplayMode(new DisplayMode(800, 800));
      Display.create();
    } catch(LWJGLException ex){
      Logger.getLogger("DisplayLogger").log(Level.SEVERE, null, ex);
    }
    
    try {
      pawn = new Pawn(new Position(0, 1), true, new Image("main/resources/whitePawn.png"));
    } catch (SlickException ex) {
      Logger.getLogger("ImageLogger").log(Level.SEVERE, null, ex);
    }
    
    assertEquals(new Position(0, 1), pawn.getLocation());
  }

}
