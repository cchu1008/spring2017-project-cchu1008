package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class Pawn extends Piece{
	public Position start;
	public Pawn(Position p, boolean white, Image image, Piece[][] board){
		super(p, white, image, board);
		this.start = p;
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		//Note: Add checks for color of pieces in destination Positions
		//Also add checks for end of board
		//Also add options for diagonal movement if enemy is diagonal
		
		if(this.start.equals(this.getLocation()) && this.board[this.start.getX()][this.start.getY()] == null){
			moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + 2));
		}
		
		for(int i = -1; i < 2; i++){
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1))){
				if(i == 0 && this.board[this.getLocation().getX()][this.getLocation().getY() + 1] == null)
					moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + 1));
				else if(this.board[this.getLocation().getX() + i][this.getLocation().getY() + 1] != null && this.board[this.getLocation().getX() + i][this.getLocation().getY() + 1].isWhite() != this.isWhite())
					moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1));
			}
		}
		
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>) moves;
	}
}
