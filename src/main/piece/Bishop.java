package main.piece;
import java.util.List;
import java.util.ArrayList;

import main.driver.GameDriver;
import main.helper.Position;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class Bishop extends Piece{
	
	public Bishop(Position p, boolean white, Image image, StateBasedGame game){
		super(p, white, image, game);
		this.setValid(validMoves());
		this.setName("Bishop");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		int i = 1;
		
		int thisX = this.getLocation().getX();
		int thisY = this.getLocation().getY();
		//Up and Right
		while(onBoard(new Position(thisX + i, thisY - i))){
			if((GameDriver.board[thisX + i][thisY - i] == null) || (GameDriver.board[thisX + i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY - i));
			if((GameDriver.board[thisX + i][thisY - i] != null))
				break;
			i++;
		}
		i = 1;
		//Up and Left
		while(onBoard(new Position(thisX - i, thisY - i)) && ((GameDriver.board[thisX - i][thisY - i] == null) || (GameDriver.board[thisX - i][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY - i] == null) || (GameDriver.board[thisX - i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY - i));
			if((GameDriver.board[thisX - i][thisY - i] != null))
				break;
			i++;
		}
		i = 1;
		//Down and Right
		while(onBoard(new Position(thisX + i, thisY + i)) && ((GameDriver.board[thisX + i][thisY + i] == null) || (GameDriver.board[thisX + i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX + i][thisY + i] == null) || (GameDriver.board[thisX + i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY + i));
			if((GameDriver.board[thisX + i][thisY + i] != null))
				break;
			i++;
		}
		i = 1;
		//Down and Left
		while(onBoard(new Position(thisX - i, thisY + i)) && ((GameDriver.board[thisX - i][thisY + i] == null) || (GameDriver.board[thisX - i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY + i] == null) || (GameDriver.board[thisX - i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY + i));
			if((GameDriver.board[thisX - i][thisY + i] != null))
				break;
			i++;
		}
		this.setValid(moves);
		return moves;
	}
}
