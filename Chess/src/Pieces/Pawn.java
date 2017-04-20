package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class Pawn extends Piece{
	public Point start;
	public Pawn(Point p, boolean white){
		super(p, white);
		this.start = p;
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		//Note: Add checks for color of pieces in destination points
		//Also add checks for end of board
		//Also add options for diagonal movement if enemy is diagonal
		
		if(this.start.equals(this.location)){
			moves.add(new Point(this.location.getX(), this.location.getY() + 2));
		}
		
		if(onBoard(new Point(this.location.getX(), this.location.getY() + 1)))
			moves.add(new Point(this.location.getX(), this.location.getY() + 1));
		if(onBoard(new Point(this.location.getX() - 1, this.location.getY() + 1)))
			moves.add(new Point(this.location.getX() - 1, this.location.getY() + 1));
		if(onBoard(new Point(this.location.getX() + 1, this.location.getY() + 1)))
			moves.add(new Point(this.location.getX() + 1, this.location.getY() + 1));
		
		this.valid = (ArrayList<Point>)moves;
		return (ArrayList<Point>) moves;
	}
}
