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
    ArrayList<Move> availableMoves = (ArrayList<Move>)ComputerPlayer.getAvailableMoves(this.isWhite(), GameDriver.getBoard());
    Move picked = ComputerPlayer.getBestMove(availableMoves);
    Logger moveLogger = Logger.getLogger("MoveLogger");
    
    if(picked != null){
      this.pickTile(picked.getStart());
      moveLogger.log(Level.INFO, "Start: " + picked.getStart().toString(), "");
      
      this.pickTile(picked.getEnd());
      moveLogger.log(Level.INFO, "End: " + picked.getEnd().toString(), "");
    }
    
  }
  
  public static List<Move> getAvailableMoves(boolean isWhite, Piece[][] board) {
    ArrayList<Move> availableMoves = new ArrayList<>();
    
    for(int j = 0; j < 8; j++){
      for(int i = 0; i < 8; i++){
        ComputerPlayer.addMoves(availableMoves, i, j, isWhite, board);
      }
    }
    return availableMoves;
  }
  
  public static void addMoves(List<Move> availableMoves, int i, int j, boolean isWhite, Piece[][] board){
    ArrayList<Position> chosen = null;
    
    if(board[i][j] != null && board[i][j].isWhite() == isWhite){
      chosen = (ArrayList<Position>) board[i][j].getValid();
      for(int k = 0; k < chosen.size(); k++){
        if(!board[i][j].getLocation().equals(chosen.get(k))){
          availableMoves.add(new Move(board[i][j].getLocation(), chosen.get(k)));
        }
      }
    }
  }
  
  public static Move getBestMove(List<Move> availableMoves){
    Random r = new Random();
    Move picked = null;
    Piece[][] currentBoard = GameDriver.getBoard();
    
    if(!availableMoves.isEmpty()){
      picked = availableMoves.get(r.nextInt(availableMoves.size()));
    }
    
    picked = ComputerPlayer.chooseMiniMax(availableMoves, 3, currentBoard, false);
    
    return picked;
  }
  
  public static Move chooseRandom(List<Move> availableMoves){
    Random r = new Random();
    
    if(!availableMoves.isEmpty()){
      return availableMoves.get(r.nextInt(availableMoves.size()));
    }
    
    else
      return null;
  }
  
  public static Move chooseCapture(Piece[][] currentBoard, Piece[][] possibleBoard, List<Move> availableMoves){
    Move picked = ComputerPlayer.chooseRandom(availableMoves);
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
  
  public static Move chooseMiniMax(List<Move> availableMoves, int depth, Piece[][] board, boolean white){
    
    int bestMoveValue = 9999;
    int index = 0;
    int[] values = new int[availableMoves.size()];
    Piece[][] possibleBoard = null;
    
    for(int i = 0; i < availableMoves.size(); i++){
      possibleBoard = ComputerPlayer.getPossibleBoard(board, availableMoves.get(i));
      values[i] = ComputerPlayer.miniMax(depth, possibleBoard, white);
    }
    
    for(int i = 0; i < availableMoves.size(); i++){
      if(bestMoveValue > values[i]){
        index = i;
        bestMoveValue = values[i];
      }
    }
    
    return availableMoves.get(index);
  }
  
  public static int miniMax(int depth, Piece[][] board, boolean white){
    if(depth == 0){
      return ComputerPlayer.boardStrength(board);
    }
    ArrayList<Move> availableMoves = (ArrayList<Move>)ComputerPlayer.getAvailableMoves(white, board);
    int bestMove = 0;
    if(white){
      bestMove = -9999;
      for(int i = 0; i < availableMoves.size(); i++){
        Piece[][] possibleBoard = ComputerPlayer.getPossibleBoard(board, availableMoves.get(i));
        if(bestMove <= ComputerPlayer.boardStrength(possibleBoard)){
          bestMove = Math.max(bestMove, miniMax(depth - 1, possibleBoard, !white));
        }
      }
      return bestMove;
    }
    else{
      bestMove = 9999;
      for(int i = 0; i < availableMoves.size(); i++){
        Piece[][] possibleBoard = ComputerPlayer.getPossibleBoard(board, availableMoves.get(i));
        if(bestMove >= ComputerPlayer.boardStrength(possibleBoard)){
          bestMove = Math.min(bestMove,  miniMax(depth - 1, possibleBoard, !white));
        }
      }
      return bestMove;
    }
    
    
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
