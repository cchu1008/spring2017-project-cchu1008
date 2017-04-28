package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class Knight extends Piece{
	public Knight(Position p, boolean white, Image image){
		super(p, white, image);
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Note: Add checks for piece color in destination
		//Also add checks for board edge
		
		for(int i = -1; i < 2; i++){
			if(i == 0) continue;
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 2)))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 2));
			
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 2)))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 2));
		}
		
		for(int i = -2; i < 3; i++){
			if(i == -2 || i == 2){
				if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1)))
					moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1));
				
				if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1)))
					moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1));
			}
		}
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>)moves;
	}
}
