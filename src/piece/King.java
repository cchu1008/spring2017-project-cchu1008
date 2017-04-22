package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;

public class King extends Piece{
	public Position start;
	public King(Position p, boolean white){
		super(p, white);
		this.start = p;
		this.valid = validMoves();
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		//Note: Add check for color of piece in destination
		//Also add check for board edge
		
		for(int i = -1; i < 2; i++){
			if(onBoard(new Position(this.location.getX() + i, this.location.getY() - 1)))
				moves.add(new Position(this.location.getX() + i, this.location.getY() - 1));

			if(i != 0 && onBoard(new Position(this.location.getX() + i, this.location.getY())))
				moves.add(new Position(this.location.getX() + i, this.location.getY() - 1));
			
			if(onBoard(new Position(this.location.getX() + i, this.location.getY() + 1)))
				moves.add(new Position(this.location.getX() + i, this.location.getY() + 1));
		}
		
		this.valid = (ArrayList<Position>)moves;
		
		return (ArrayList<Position>)moves;
	}
}
