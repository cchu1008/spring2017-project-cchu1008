package main.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import main.helper.Move;
import main.helper.Position;
import main.piece.Piece;

public class ComputerPlayer extends Player {
  public ComputerPlayer(StateBasedGame game, GameContainer container) {
    super("CPU", false, game, container);
  }
  
  public void movePiece(){
    ArrayList<Move> availableMoves = (ArrayList<Move>)ComputerPlayer.getAvailableMoves(this.isWhite());
    Move picked = ComputerPlayer.getBestMove(availableMoves);
    Logger moveLogger = Logger.getLogger("MoveLogger");
    
    this.pickTile(picked.getStart());
    moveLogger.log(Level.INFO, "Start: " + picked.getStart().toString(), "");
    
    this.pickTile(picked.getEnd());
    moveLogger.log(Level.INFO, "End: " + picked.getEnd().toString(), "");
    
  }
  
  public static List<Move> getAvailableMoves(boolean isWhite) {
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
  
  public static Move getBestMove(List<Move> availableMoves){
    Random r = new Random();
    Move picked = availableMoves.get(r.nextInt(availableMoves.size()));
    Piece[][] currentBoard = GameDriver.getBoard();
    Piece[][] possibleBoard = currentBoard;
/*  Random r = new Random();
    
    if(!availableMoves.isEmpty()){
      picked = availableMoves.get(r.nextInt(availableMoves.size()));
    }*/
    
    int currentBoardStrength = ComputerPlayer.boardStrength(currentBoard);
    int possibleBoardStrength = currentBoardStrength;
    int bestStrength = currentBoardStrength;
    
    for(int i = 0; i < availableMoves.size(); i++){
      possibleBoard = ComputerPlayer.getPossibleBoard(currentBoard, availableMoves.get(i));
      possibleBoardStrength = ComputerPlayer.boardStrength(possibleBoard);
      
      if(possibleBoardStrength < bestStrength){
        picked = availableMoves.get(i);
        bestStrength = possibleBoardStrength;
      }
    }
    
    return picked;
  }
  
  public static Piece[][] getPossibleBoard(Piece[][] currentBoard, Move move){
    Piece[][] possibleBoard = ComputerPlayer.copyBoard(currentBoard);
    Piece piece = possibleBoard[move.getStart().getX()][move.getStart().getY()];
    
    possibleBoard[move.getEnd().getX()][move.getEnd().getY()] = piece;
    possibleBoard[move.getStart().getX()][move.getStart().getY()] = null;
    
    return possibleBoard;
    
  }
  
  public static Piece[][] copyBoard(Piece[][] board){
    Piece[][] newBoard = new Piece[8][8];
    
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        newBoard[i][j] = board[i][j];
      }
    }
    
    return newBoard;
  }
  
  public static int boardStrength(Piece[][] board){
    int sum = 0;
    
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        if(board[i][j] != null){
          sum += board[i][j].getStrength();
        }
      }
    }
    
    return sum;
  }
  
}
