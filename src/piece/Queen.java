package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
public class Queen extends Piece{
	public Queen(Position p, boolean white, Image image, Piece[][] board){
		super(p, white, image, board);
		this.setValid(validMoves());
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Bishop moves
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i < 8 && j < 8 && (this.board[i][j] == null || this.board[i][j].isWhite() != this.isWhite()); i++, j++){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i >= 0 && j >= 0 && (this.board[i][j] == null || this.board[i][j].isWhite() != this.isWhite()); i--, j--){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i >= 0 && j < 8 && (this.board[i][j] == null || this.board[i][j].isWhite() != this.isWhite()); i--, j++){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		for(int i = this.getLocation().getX(), j = this.getLocation().getY(); i < 8 && j >= 0 && (this.board[i][j] == null || this.board[i][j].isWhite() != this.isWhite()); i++, j--){
			if(this.getLocation().getX() != i || this.getLocation().getY() != j){
				moves.add(new Position(i, j));
			}
		}
		
		//Rook moves
		for(int i = this.getLocation().getX() + 1; i < 8 && (this.board[i][this.getLocation().getY()] == null || this.board[i][this.getLocation().getY()].isWhite() != this.isWhite()); i++){
			moves.add(new Position(i, this.getLocation().getY()));
		}
		for(int i = this.getLocation().getX() - 1; i >= 0 && (this.board[i][this.getLocation().getY()] == null || this.board[i][this.getLocation().getY()].isWhite() != this.isWhite()); i--){
			moves.add(new Position(i, this.getLocation().getY()));
		}
		
		for(int i = this.getLocation().getY() + 1; i < 8 && (this.board[this.getLocation().getX()][i] == null || this.board[this.getLocation().getX()][i].isWhite() != this.isWhite()); i++){
			moves.add(new Position(this.getLocation().getX(), i));
		}
		for(int i = this.getLocation().getY() - 1; i >= 0 && (this.board[this.getLocation().getX()][i] == null || this.board[this.getLocation().getX()][i].isWhite() != this.isWhite()); i--){
			moves.add(new Position(this.getLocation().getX(), i));
		}
		
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>)moves;
	}
}
