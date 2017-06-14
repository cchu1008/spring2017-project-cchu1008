package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.driver.ComputerPlayer;
import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Move;
import main.helper.Position;
import main.piece.Pawn;

public class ComputerPlayerTest {

  @Test
  public void testAddMoves() {
    GameDriver.clearBoard();
    ArrayList<Move> availableMoves = new ArrayList<>();
    
    ArrayList<Move> validMoves = new ArrayList<>();
    
    ComputerPlayer.addMoves(availableMoves, 0, 0, true, GameDriver.getBoard());
    
    assertTrue(availableMoves.isEmpty());
    
    Pawn p = new Pawn(new Position(0, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[0][1] = p;
    
    ComputerPlayer.addMoves(availableMoves, 0, 1, false, GameDriver.getBoard());
    
    validMoves.add(new Move(new Position(0, 1), new Position(0, 3)));
    validMoves.add(new Move(new Position(0, 1), new Position(0, 2)));
    
    assertEquals(validMoves, availableMoves);
  }
  
  @Test
  public void testGetAvailableMoves(){
    GameDriver.clearBoard();
    Pawn p = new Pawn(new Position(0, 1), false, ImageType.BLACK_PAWN);
    GameDriver.getBoard()[0][1] = p;

    ArrayList<Move> validMoves = new ArrayList<>();
    
    ArrayList<Move> availableMoves = (ArrayList<Move>)ComputerPlayer.getAvailableMoves(false, GameDriver.getBoard());
    
    validMoves.add(new Move(new Position(0, 1), new Position(0, 3)));
    validMoves.add(new Move(new Position(0, 1), new Position(0, 2)));
    
    assertEquals(validMoves, availableMoves);
  }

}
