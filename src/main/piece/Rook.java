package main.piece;
import java.util.ArrayList;
import java.util.List;

import main.helper.Position;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
public class Rook extends Piece{
	public Position start;
	
	public Rook(Position p, boolean white, Image image, StateBasedGame game){
		super(p, white, image, game);
		this.start = p;
		this.setValid(validMoves());
		this.setName(" Rook ");
	}
	
	public ArrayList<Position> validMoves(){
		//Note: Add in check for color of piece in destination spot.
		List<Position> moves = new ArrayList<Position>();
		int i = 1;
		
		/**
		if(this.start.equals(this.getLocation())){
			//Castle move
		}**/
		
		//Right
		while(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY())) && ((this.game.board[this.getLocation().getX() + i][this.getLocation().getY()] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY()].isWhite() != this.isWhite()))){
			moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY()));
			i++;
		}
		
		i = 1;
		//Left
		
		while(onBoard(new Position(this.getLocation().getX() - i, this.getLocation().getY())) && ((this.game.board[this.getLocation().getX() - i][this.getLocation().getY()] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY()].isWhite() != this.isWhite()))){
			moves.add(new Position(this.getLocation().getX() - i, this.getLocation().getY()));
			i++;
		}
		
		i = 1;
		//Up
		while(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() - i)) && ((this.game.board[this.getLocation().getX()][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX()][this.getLocation().getY() - i].isWhite() != this.isWhite()))){
			moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() - i));
			i++;
		}
		i = 1;
		//Down
		while(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() + i)) && ((this.game.board[this.getLocation().getX()][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX()][this.getLocation().getY() + i].isWhite() != this.isWhite()))){
			moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + i));
			i++;
		}
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>)moves;
	}
}
