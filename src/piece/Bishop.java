package piece;
import java.util.List;
import java.util.ArrayList;
import helper.Position;
import org.newdawn.slick.Image;

public class Bishop extends Piece{
	public Bishop(Position p, boolean white, Image image){
		super(p, white, image);
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Note: Add check for color of piece in destination
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i < 8 && j < 8; i++, j++){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i >= 0 && j >= 0; i--, j--){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i >= 0 && j < 8; i--, j++){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i < 8 && j >= 0; i++, j--){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>)moves;
	}
}
