package main.piece;
import java.util.List;

import main.driver.GameDriver;
import main.helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
public class Knight extends Piece{
	
	public Knight(Position p, boolean white, Image image, StateBasedGame game){
		super(p, white, image, game);
		this.setValid(validMoves());
		this.setName("Knight");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		Position p;
		
		for(int i = -1; i < 2; i++){
			if(i == 0) i++;
			p = new Position(this.getLocation().getX() + i, this.getLocation().getY() + 2);
			if(onBoard(p) && (this.game.isEmpty(p) || GameDriver.board[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
			p = new Position(this.getLocation().getX() + i, this.getLocation().getY() - 2);
			if(onBoard(p) && (this.game.isEmpty(p) || GameDriver.board[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
			p = new Position(this.getLocation().getX() + 2, this.getLocation().getY() + i);
			if(onBoard(p) && (this.game.isEmpty(p) || GameDriver.board[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
			p = new Position(this.getLocation().getX() - 2, this.getLocation().getY() + i);
			if(onBoard(p) && (this.game.isEmpty(p) || GameDriver.board[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
		}
		this.setValid(moves);
		return moves;
	}
}
