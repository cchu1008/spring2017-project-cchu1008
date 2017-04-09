package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class Pawn extends Piece{
	public Pawn(Point p, boolean white){
		this.location = p;
		this.isWhite = white;
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		//Note: Add checks for color of pieces in destination points
		//Also add checks for end of board
		moves.add(new Point(this.location.getX(), this.location.getY() + 1));
		moves.add(new Point(this.location.getX() - 1, this.location.getY() + 1));
		moves.add(new Point(this.location.getX() + 1, this.location.getY() + 1));
		return (ArrayList<Point>) moves;
	}
}
