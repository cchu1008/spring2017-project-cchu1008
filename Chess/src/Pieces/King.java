package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class King extends Piece{
	public Point start;
	public King(Point p, boolean white){
		super(p, white);
		this.start = p;
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		//Note: Add check for color of piece in destination
		//Also add check for board edge
		
		for(int i = -1; i < 2; i++){
			if(onBoard(new Point(this.location.getX() + i, this.location.getY() - 1)))
				moves.add(new Point(this.location.getX() + i, this.location.getY() - 1));

			if(i != 0 && onBoard(new Point(this.location.getX() + i, this.location.getY())))
				moves.add(new Point(this.location.getX() + i, this.location.getY() - 1));
			
			if(onBoard(new Point(this.location.getX() + i, this.location.getY() + 1)))
				moves.add(new Point(this.location.getX() + i, this.location.getY() + 1));
		}
		
		return (ArrayList<Point>)moves;
	}
}
