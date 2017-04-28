package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class Bishop extends Piece{
	public Bishop(Position p, boolean white, Image image){
		super(p, white, image);
		this.valid = validMoves();
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Note: Add check for color of piece in destination
		
		for(int i = this.location.getX(), j = this.location.getY(); i < 8 && j < 8; i++, j++){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.location.getX(), j = this.location.getY(); i >= 0 && j >= 0; i--, j--){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.location.getX(), j = this.location.getY(); i >= 0 && j < 8; i--, j++){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.location.getX(), j = this.location.getY(); i < 8 && j >= 0; i++, j--){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		this.valid = (ArrayList<Position>)moves;
		return (ArrayList<Position>)moves;
	}
}
