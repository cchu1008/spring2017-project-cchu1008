package piece;
import java.util.ArrayList;
import java.util.List;

import helper.Position;
import org.newdawn.slick.Image;
public class Rook extends Piece{
	public Position start;
	public Rook(Position p, boolean white, Image image){
		super(p, white, image);
		this.start = p;
		this.valid = validMoves();
	}
	
	public ArrayList<Position> validMoves(){
		//Note: Add in check for color of piece in destination spot.
		List<Position> moves = new ArrayList<Position>();
		for(int i = 0; i < 8; i++){
			if(i != this.location.getX()){
				moves.add(new Position(i, this.location.getY()));
			}
		}
		for(int j = 0; j < 8; j++){
			if(j != this.location.getY()){
				moves.add(new Position(this.location.getX(), j));
			}
		}
		this.valid = (ArrayList<Position>)moves;
		return (ArrayList<Position>)moves;
	}
}
