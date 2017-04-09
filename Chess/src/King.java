import java.util.List;
import java.util.ArrayList;

public class King extends Piece{
	public King(Point p, boolean white){
		this.location = p;
		this.isWhite = white;
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		//Note: Add check for color of piece in destination
		//Also add check for board edge
		
		moves.add(new Point(this.location.getX() - 1, this.location.getY()));
		moves.add(new Point(this.location.getX() + 1, this.location.getY()));
		moves.add(new Point(this.location.getX(), this.location.getY() + 1));
		moves.add(new Point(this.location.getX(), this.location.getY() - 1));
		moves.add(new Point(this.location.getX() - 1, this.location.getY() + 1));
		moves.add(new Point(this.location.getX() + 1, this.location.getY() + 1));
		moves.add(new Point(this.location.getX() - 1, this.location.getY() - 1));
		moves.add(new Point(this.location.getX() + 1, this.location.getY() - 1));
		
		return (ArrayList<Point>)moves;
	}
}
