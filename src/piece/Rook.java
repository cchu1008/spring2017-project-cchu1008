package piece;
import java.util.ArrayList;
import java.util.List;

import helper.Position;
import org.newdawn.slick.Image;
public class Rook extends Piece{
	public Position start;
	public Rook(Position p, boolean white, Image image, Piece[][] board){
		super(p, white, image, board);
		this.start = p;
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		//Note: Add in check for color of piece in destination spot.
		List<Position> moves = new ArrayList<Position>();
		
		if(this.start.equals(this.getLocation())){
			//Castle move
		}
		
		for(int i = this.getLocation().getX() + 1; i < 8 && (this.board[i][this.getLocation().getY()] == null || this.board[i][this.getLocation().getY()].isWhite() != this.isWhite()); i++){
			moves.add(new Position(i, this.getLocation().getY()));
		}
		for(int i = this.getLocation().getX() - 1; i >= 0 && (this.board[i][this.getLocation().getY()] == null || this.board[i][this.getLocation().getY()].isWhite() != this.isWhite()); i++){
			moves.add(new Position(i, this.getLocation().getY()));
		}
		
		for(int i = this.getLocation().getY() + 1; i < 8 && (this.board[this.getLocation().getX()][i] == null || this.board[this.getLocation().getX()][i].isWhite() != this.isWhite()); i++){
			moves.add(new Position(this.getLocation().getX(), i));
		}
		for(int i = this.getLocation().getY() - 1; i >= 0 && (this.board[this.getLocation().getX()][i] == null || this.board[this.getLocation().getX()][i].isWhite() != this.isWhite()); i++){
			moves.add(new Position(this.getLocation().getX(), i));
		}
		
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>)moves;
	}
}
