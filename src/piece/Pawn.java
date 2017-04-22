package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;

public class Pawn extends Piece{
	public Position start;
	public Pawn(Position p, boolean white){
		super(p, white);
		this.start = p;
		this.valid = validMoves();
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		//Note: Add checks for color of pieces in destination Positions
		//Also add checks for end of board
		//Also add options for diagonal movement if enemy is diagonal
		
		if(this.start.equals(this.location)){
			moves.add(new Position(this.location.getX(), this.location.getY() + 2));
		}
		
		if(onBoard(new Position(this.location.getX(), this.location.getY() + 1)))
			moves.add(new Position(this.location.getX(), this.location.getY() + 1));
		if(onBoard(new Position(this.location.getX() - 1, this.location.getY() + 1)))
			moves.add(new Position(this.location.getX() - 1, this.location.getY() + 1));
		if(onBoard(new Position(this.location.getX() + 1, this.location.getY() + 1)))
			moves.add(new Position(this.location.getX() + 1, this.location.getY() + 1));
		
		this.valid = (ArrayList<Position>)moves;
		return (ArrayList<Position>) moves;
	}
}
