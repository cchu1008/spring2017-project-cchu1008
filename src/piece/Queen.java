package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class Queen extends Piece{
	public Queen(Position p, boolean white, Image image){
		super(p, white, image);
		this.valid = validMoves();
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Bishop moves
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
		
		//Rook moves
		for(int i = 0; i < 8; i++){
			if(i != this.location.getX() && !moves.contains(new Position(i, this.location.getY()))){
				moves.add(new Position(i, this.location.getY()));
			}
		}
		for(int j = 0; j < 8; j++){
			if(j != this.location.getY() && !moves.contains(new Position(this.location.getX(), j))){
				moves.add(new Position(this.location.getX(), j));
			}
		}
		this.valid = (ArrayList<Position>)moves;
		return (ArrayList<Position>)moves;
	}
}
