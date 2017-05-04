package main.piece;
import java.util.List;

import main.driver.GameDriver;
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
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		int i = 1;
		int thisX = this.getLocation().getX();
		int thisY = this.getLocation().getY();

		//Bishop moves
		
		//Up and Right
		while(onBoard(new Position(thisX + i, thisY - i))){
			if((GameDriver.board[thisX + i][thisY - i] == null) || (GameDriver.board[thisX + i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY - i));
			if(GameDriver.board[thisX + i][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Up and Left
		while(onBoard(new Position(thisX - i, thisY - i)) && ((GameDriver.board[thisX - i][thisY - i] == null) || (GameDriver.board[thisX - i][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY - i] == null) || (GameDriver.board[thisX - i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY - i));
			if(GameDriver.board[thisX - i][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Down and Right
		while(onBoard(new Position(thisX + i, thisY + i)) && ((GameDriver.board[thisX + i][thisY + i] == null) || (GameDriver.board[thisX + i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX + i][thisY + i] == null) || (GameDriver.board[thisX + i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY + i));
			if(GameDriver.board[thisX + i][thisY + i] != null)
				break;
			i++;
		}
		i = 1;
		//Down and Left
		while(onBoard(new Position(thisX - i, thisY + i)) && ((GameDriver.board[thisX - i][thisY + i] == null) || (GameDriver.board[thisX - i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY + i] == null) || (GameDriver.board[thisX - i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY + i));
			if(GameDriver.board[thisX - i][thisY + i] != null)
				break;
			i++;
		}
		
		i = 1;
		//Rook moves
		
		//Right
		while(onBoard(new Position(thisX + i, thisY))){
			if((GameDriver.board[thisX + i][thisY] == null) || (GameDriver.board[thisX + i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY));
			if(GameDriver.board[thisX + i][thisY] != null)
				break;
			i++;
		}
		i = 1;
		//Up
		while(onBoard(new Position(thisX, thisY - i)) && ((GameDriver.board[thisX][thisY - i] == null) || (GameDriver.board[thisX][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX][thisY - i] == null) || (GameDriver.board[thisX][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY - i));
			if(GameDriver.board[thisX][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Down
		while(onBoard(new Position(thisX, thisY + i)) && ((GameDriver.board[thisX][thisY + i] == null) || (GameDriver.board[thisX][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX][thisY + i] == null) || (GameDriver.board[thisX][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY + i));
			if(GameDriver.board[thisX][thisY + i] != null)
				break;
			i++;
		}
		i = 1;
		//Left
		while(onBoard(new Position(thisX - i, thisY)) && ((GameDriver.board[thisX - i][thisY] == null) || (GameDriver.board[thisX - i][thisY].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY] == null) || (GameDriver.board[thisX - i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY));
			if(GameDriver.board[thisX - i][thisY] != null)
				break;
			i++;
		}
		
		this.setValid(moves);
		return moves;
	}
}
