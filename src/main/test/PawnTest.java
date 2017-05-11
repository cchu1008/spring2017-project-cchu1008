package main.test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.sun.javaws.Main;

import main.driver.GameDriver;
import main.helper.Position;
import main.piece.Pawn;

public class PawnTest {    
  public GameDriver game = new GameDriver("Chess");
  public Pawn pawn;

  @Test
  public void testConstructor() {
    try{
      Display.setDisplayMode(new DisplayMode(800, 800));
      Display.create();
    } catch(LWJGLException ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      pawn = new Pawn(new Position(0, 1), true, new Image("main/resources/whitePawn.png"), game);
    } catch (SlickException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    assertEquals(new Position(0, 1), pawn.getLocation());
  }

}
