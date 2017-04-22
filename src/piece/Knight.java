package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;

public class Knight extends Piece{
	public Knight(Position p, boolean white){
		super(p, white);
		this.valid = validMoves();
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Note: Add checks for piece color in destination
		//Also add checks for board edge
		
		for(int i = -1; i < 2; i++){
			if(i == 0) continue;
			if(onBoard(new Position(this.location.getX() + i, this.location.getY() + 2)))
				moves.add(new Position(this.location.getX() + i, this.location.getY() + 2));
			
			if(onBoard(new Position(this.location.getX() + i, this.location.getY() - 2)))
				moves.add(new Position(this.location.getX() + i, this.location.getY() - 2));
		}
		
		for(int i = -2; i < 3; i++){
			if(i == -2 || i == 2){
				if(onBoard(new Position(this.location.getX() + i, this.location.getY() + 1)))
					moves.add(new Position(this.location.getX() + i, this.location.getY() + 1));
				
				if(onBoard(new Position(this.location.getX() + i, this.location.getY() - 1)))
					moves.add(new Position(this.location.getX() + i, this.location.getY() - 1));
			}
		}
		this.valid = (ArrayList<Position>)moves;
		return (ArrayList<Position>)moves;
	}
}
