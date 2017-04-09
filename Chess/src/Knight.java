import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece{
	public Knight(Point p, boolean white){
		this.location = p;
		this.isWhite = white;
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		
		//Note: Add checks for piece color in destination
		//Also add checks for board edge
		moves.add(new Point(this.location.getX() - 1, this.location.getY() + 2));
		moves.add(new Point(this.location.getX() + 1, this.location.getY() + 2));
		moves.add(new Point(this.location.getX() - 1, this.location.getY() - 2));
		moves.add(new Point(this.location.getX() + 1, this.location.getY() - 2));
		moves.add(new Point(this.location.getX() + 2, this.location.getY() + 1));
		moves.add(new Point(this.location.getX() + 2, this.location.getY() - 1));
		moves.add(new Point(this.location.getX() - 2, this.location.getY() + 1));
		moves.add(new Point(this.location.getX() - 2, this.location.getY() - 1));
		
		return (ArrayList<Point>)moves;
	}
}
