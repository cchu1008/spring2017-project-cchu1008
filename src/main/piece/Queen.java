package main.piece;
import java.util.List;

import main.helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
public class Queen extends Piece{
	
	public Queen(Position p, boolean white, Image image, StateBasedGame game){
		super(p, white, image, game);
		this.setValid(validMoves());
		this.setName(" Queen");
	}
	
	public void move(Position p){
		this.setLocation(p);
		this.setValid(validMoves());
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		int i = 1;
		
		//Bishop moves
		
		//Up and Right
		while(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - i))){
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - i));
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - i] != null))
				break;
			i++;
		}
		i = 1;
		//Up and Left
		while(onBoard(new Position(this.getLocation().getX() - i, this.getLocation().getY() - i)) && ((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() - i, this.getLocation().getY() - i));
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i] != null))
				break;
			i++;
		}
		i = 1;
		//Down and Right
		while(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + i)) && ((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + i));
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i] != null))
				break;
			i++;
		}
		i = 1;
		//Down and Left
		while(onBoard(new Position(this.getLocation().getX() - i, this.getLocation().getY() + i)) && ((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() - i, this.getLocation().getY() + i));
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i] != null))
				break;
			i++;
		}
		
		//Rook moves
		
		//Right
		while(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY()))){
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY()] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY()].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY()));
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY()] != null))
				break;
			i++;
		}
		i = 1;
		//Up
		while(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() - i)) && ((this.game.board[this.getLocation().getX()][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX()][this.getLocation().getY() - i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX()][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX()][this.getLocation().getY() - i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() - i));
			if((this.game.board[this.getLocation().getX()][this.getLocation().getY() - i] != null))
				break;
			i++;
		}
		i = 1;
		//Down
		while(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() + i)) && ((this.game.board[this.getLocation().getX()][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX()][this.getLocation().getY() + i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX()][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX()][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + i));
			if((this.game.board[this.getLocation().getX()][this.getLocation().getY() + i] != null))
				break;
			i++;
		}
		i = 1;
		//Left
		while(onBoard(new Position(this.getLocation().getX() - i, this.getLocation().getY())) && ((this.game.board[this.getLocation().getX() - i][this.getLocation().getY()] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY()].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY()] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY()].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() - i, this.getLocation().getY()));
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY()] != null))
				break;
			i++;
		}
		
		this.setValid((ArrayList<Position>)moves);
		return moves;
	}
}
