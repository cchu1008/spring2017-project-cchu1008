package main.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import main.helper.Move;
import main.helper.Position;

public class ComputerPlayer extends Player {
  public ComputerPlayer(StateBasedGame game, GameContainer container) {
    super("CPU", false, game, container);
  }
  
  public void movePiece(){
    ArrayList<Move> availableMoves = (ArrayList<Move>)ComputerPlayer.getAvailableMoves(this.isWhite());
    Move picked = null;
    
    if(!availableMoves.isEmpty()){
      picked = availableMoves.get((int) (Math.random()* availableMoves.size()));
      Logger moveLogger = Logger.getLogger("MoveLogger");
      
      this.pickTile(picked.getStart());
      moveLogger.log(Level.INFO, "Start: " + picked.getStart().toString(), "");
      
      this.pickTile(picked.getEnd());
      moveLogger.log(Level.INFO, "End: " + picked.getEnd().toString(), "");
    }
    
  }
  
  public static List<Move> getAvailableMoves(boolean isWhite){
    ArrayList<Move> availableMoves = new ArrayList<>();
    
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        ComputerPlayer.addMoves(availableMoves, i, j, isWhite);
      }
    }
    return availableMoves;
  }
  
  public static void addMoves(List<Move> availableMoves, int i, int j, boolean isWhite){
    ArrayList<Position> chosen = null;
    
    if(GameDriver.getBoard()[i][j] != null && GameDriver.getBoard()[i][j].isWhite() == isWhite){
      chosen = (ArrayList<Position>) GameDriver.getBoard()[i][j].getValid();
      for(int k = 0; k < chosen.size(); k++){
        if(!GameDriver.getBoard()[i][j].getLocation().equals(chosen.get(k))){
          availableMoves.add(new Move(GameDriver.getBoard()[i][j].getLocation(), chosen.get(k)));
        }
      }
    }
  }
}
