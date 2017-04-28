package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class Pawn extends Piece{
	public Position start;
	public Pawn(Position p, boolean white, Image image){
		super(p, white, image);
		this.start = p;
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		//Note: Add checks for color of pieces in destination Positions
		//Also add checks for end of board
		//Also add options for diagonal movement if enemy is diagonal
		
		if(this.start.equals(this.getLocation())){
			moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + 2));
		}
		
		if(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() + 1)))
			moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + 1));
		if(onBoard(new Position(this.getLocation().getX() - 1, this.getLocation().getY() + 1)))
			moves.add(new Position(this.getLocation().getX() - 1, this.getLocation().getY() + 1));
		if(onBoard(new Position(this.getLocation().getX() + 1, this.getLocation().getY() + 1)))
			moves.add(new Position(this.getLocation().getX() + 1, this.getLocation().getY() + 1));
		
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>) moves;
	}
}
