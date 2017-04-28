package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class King extends Piece{
	public Position start;
	public King(Position p, boolean white, Image image){
		super(p, white, image);
		this.start = p;
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		//Note: Add check for color of piece in destination
		//Also add check for board edge
		
		for(int i = -1; i < 2; i++){
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1)))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1));

			if(i != 0 && onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY())))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1));
			
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1)))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1));
		}
		
		this.setValid((ArrayList<Position>)moves);
		
		return (ArrayList<Position>)moves;
	}
}
