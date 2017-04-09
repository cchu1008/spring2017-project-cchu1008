package Pieces;
import java.util.List;

import helper.Point;

import java.util.ArrayList;

public class Queen extends Piece{
	public Queen(Point p, boolean white){
		super(p, white);
		this.valid = validMoves();
	}
	
	public ArrayList<Point> validMoves(){
		List<Point> moves = new ArrayList<Point>();
		
		//Bishop moves
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
		
		//Rook moves
		for(int i = 0; i < 8; i++){
			if(i != this.location.getX() && !moves.contains(new Point(i, this.location.getY()))){
				moves.add(new Point(i, this.location.getY()));
			}
		}
		for(int j = 0; j < 8; j++){
			if(j != this.location.getY() && !moves.contains(new Point(this.location.getX(), j))){
				moves.add(new Point(this.location.getX(), j));
			}
		}
		
		return (ArrayList<Point>)moves;
	}
}
