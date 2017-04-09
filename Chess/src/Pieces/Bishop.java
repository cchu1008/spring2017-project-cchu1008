package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class Bishop extends Piece{
	public Bishop(Point p, boolean white){
		this.location = p;
		this.isWhite = white;
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		
		//Note: Add check for color of piece in destination
		//Also add check for edge of board
		
		for(int i = 0, j = 0; i < 8 && j < 8; i++, j++){
			if(this.location.getX() != i || this.location.getY() != j){
				moves.add(new Point(i, j));
			}
		}
		for(int i = 0, j = 7; i < 8 && j >= 0; i++, j--){
			if((this.location.getX() != i || this.location.getY() != j) && !moves.contains(new Point(i, j))){
				moves.add(new Point(i, j));
			}
		}
		
		return (ArrayList<Point>)moves;
	}
}
