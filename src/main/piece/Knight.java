package main.piece;
import java.util.List;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;

import java.util.ArrayList;

public class Knight extends Piece{
	
	public Knight(Position p, boolean white, ImageType image){
		super(p, white, image);
		this.setValid(validMoves());
		this.setName("Knight");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<>();
		Position p;
		
		for(int i = -1; i < 2; i++){
			if(i == 0)
				continue;
			p = new Position(this.getLocation().getX() + i, this.getLocation().getY() + 2);
			if(onBoard(p) && (GameDriver.isEmpty(p) || GameDriver.getBoard()[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
			p = new Position(this.getLocation().getX() + i, this.getLocation().getY() - 2);
			if(onBoard(p) && (GameDriver.isEmpty(p) || GameDriver.getBoard()[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
			p = new Position(this.getLocation().getX() + 2, this.getLocation().getY() + i);
			if(onBoard(p) && (GameDriver.isEmpty(p) || GameDriver.getBoard()[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
			p = new Position(this.getLocation().getX() - 2, this.getLocation().getY() + i);
			if(onBoard(p) && (GameDriver.isEmpty(p) || GameDriver.getBoard()[p.getX()][p.getY()].isWhite() != this.isWhite()))
				moves.add(p);
		}
		this.setValid(moves);
		return moves;
	}
}
