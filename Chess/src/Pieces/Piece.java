package Pieces;
import java.util.ArrayList;

import helper.Point;

public abstract class Piece {
	public Point location;
	public ArrayList<Point> valid;
	boolean isWhite;
	
	public Piece(Point p, boolean white){
		this.location = p;
		this.valid = validMoves();
		this.isWhite = white;
	}
	
	public Piece(){
		this.location = new Point(0, 0);
	}
	
	public void move(Point point){
		if(isValid(point)) this.location = point;
	}
	public ArrayList<Point> validMoves(){
		return new ArrayList<Point>();
	}
	public boolean isValid(Point point){
		return this.valid.contains(point);
	}
	public boolean onBoard(Point point){
		return (point.getX() >= 0 && point.getX() < 8 && point.getY() >= 0 && point.getY() < 8);
	}
}
