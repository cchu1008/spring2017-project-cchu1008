package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class Knight extends Piece{
	public Knight(Point p, boolean white){
		super(p, white);
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		
		//Note: Add checks for piece color in destination
		//Also add checks for board edge
		
		for(int i = -1; i < 2; i++){
			if(i == 0) continue;
			if(onBoard(new Point(this.location.getX() + i, this.location.getY() + 2)))
				moves.add(new Point(this.location.getX() + i, this.location.getY() + 2));
			
			if(onBoard(new Point(this.location.getX() + i, this.location.getY() - 2)))
				moves.add(new Point(this.location.getX() + i, this.location.getY() - 2));
		}
		
		for(int i = -2; i < 3; i++){
			if(i == -2 || i == 2){
				if(onBoard(new Point(this.location.getX() + i, this.location.getY() + 1)))
					moves.add(new Point(this.location.getX() + i, this.location.getY() + 1));
				
				if(onBoard(new Point(this.location.getX() + i, this.location.getY() - 1)))
					moves.add(new Point(this.location.getX() + i, this.location.getY() - 1));
			}
		}
		
		return (ArrayList<Point>)moves;
	}
}
