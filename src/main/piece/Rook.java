package main.piece;
import java.util.ArrayList;
import java.util.List;

import main.driver.GameDriver;
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
	
	@Override
	public List<Position> validMoves(){
		//Note: Add in check for color of piece in destination spot.
		List<Position> moves = new ArrayList<Position>();
		int i = 1;
		int thisX = this.getLocation().getX();
		int thisY = this.getLocation().getY();
		//Rook moves
		
		//Right
		while(onBoard(new Position(thisX + i, thisY))){
			if((GameDriver.board[thisX + i][thisY] == null) || (GameDriver.board[thisX + i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY));
			if((GameDriver.board[thisX + i][thisY] != null))
				break;
			i++;
		}
		i = 1;
		//Up
		while(onBoard(new Position(thisX, thisY - i)) && ((GameDriver.board[thisX][thisY - i] == null) || (GameDriver.board[thisX][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX][thisY - i] == null) || (GameDriver.board[thisX][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY - i));
			if((GameDriver.board[thisX][thisY - i] != null))
				break;
			i++;
		}
		i = 1;
		//Down
		while(onBoard(new Position(thisX, thisY + i)) && ((GameDriver.board[thisX][thisY + i] == null) || (GameDriver.board[thisX][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX][thisY + i] == null) || (GameDriver.board[thisX][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY + i));
			if((GameDriver.board[thisX][thisY + i] != null))
				break;
			i++;
		}
		i = 1;
		//Left
		while(onBoard(new Position(thisX - i, thisY)) && ((GameDriver.board[thisX - i][thisY] == null) || (GameDriver.board[thisX - i][thisY].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY] == null) || (GameDriver.board[thisX - i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY));
			if((GameDriver.board[thisX - i][thisY] != null))
				break;
			i++;
		}
		
		this.setValid(moves);
		return moves;
	}
}
