package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class Bishop extends Piece{
	public Bishop(Point p, boolean white){
		super(p, white);
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		
		//Note: Add check for color of piece in destination
		
		for(int i = this.location.getX(), j = this.location.getY(); i < 8 && j < 8; i++, j++){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Point(i, j));
			}
		}
		
		for(int i = this.location.getX(), j = this.location.getY(); i >= 0 && j >= 0; i--, j--){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Point(i, j));
			}
		}
		
		for(int i = this.location.getX(), j = this.location.getY(); i >= 0 && j < 8; i--, j++){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Point(i, j));
			}
		}
		
		for(int i = this.location.getX(), j = this.location.getY(); i < 8 && j >= 0; i++, j--){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Point(i, j));
			}
		}
		
		this.valid = (ArrayList<Point>)moves;
		return (ArrayList<Point>)moves;
	}
}
