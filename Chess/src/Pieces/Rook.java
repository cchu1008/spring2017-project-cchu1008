package Pieces;
import java.util.ArrayList;
import java.util.List;

import helper.Point;

public class Rook extends Piece{
	public Rook(Point p, boolean white){
		this.location = p;
		this.valid = validMoves();
		this.isWhite = white;
	}
	
	public ArrayList<Point> validMoves(){
		//Note: Add in check for color of piece in destination spot.
		List<Point> moves = new ArrayList<Point>();
		for(int i = 0; i < 8; i++){
			if(i != this.location.getX()){
				moves.add(new Point(i, this.location.getY()));
			}
		}
		for(int j = 0; j < 8; j++){
			if(j != this.location.getY()){
				moves.add(new Point(this.location.getX(), j));
			}
		}
		
		return (ArrayList<Point>)moves;
	}
}
