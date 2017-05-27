package main.piece;
import java.util.List;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;

import java.util.ArrayList;

public class King extends Piece{
	public Position start;
	
	public King(Position p, boolean white, ImageType image){
		super(p, white, image);
		this.start = p;
		this.setValid(validMoves());
		this.setName(" King ");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<>();
		//Note: Add check for color of piece in destination
		//Also add check for GameDriver.board edge
		
		for(int i = -1; i < 2; i++){
			//bottom row
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1)) && (GameDriver.getBoard()[this.getLocation().getX() + i][this.getLocation().getY() + 1] == null || GameDriver.getBoard()[this.getLocation().getX() + i][this.getLocation().getY() + 1].isWhite() != this.isWhite())){
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 1));
			}
			//middle minus current
			if(i != 0 && onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY())) && (GameDriver.getBoard()[this.getLocation().getX() + i][this.getLocation().getY()] == null || GameDriver.getBoard()[this.getLocation().getX() + i][this.getLocation().getY()].isWhite() != this.isWhite())){
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY()));
			}
			//top row
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1)) && (GameDriver.getBoard()[this.getLocation().getX() + i][this.getLocation().getY() - 1] == null || GameDriver.getBoard()[this.getLocation().getX() + i][this.getLocation().getY() - 1].isWhite() != this.isWhite())){
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 1));
			}
		}
		
		this.setValid(moves);
		
		return moves;
	}
}
