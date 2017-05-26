package main.piece;
import java.util.List;

import main.helper.ImageType;
import main.helper.Position;

public class Bishop extends Piece{
	
	public Bishop(Position p, boolean white, ImageType image){
		super(p, white, image);
		this.setValid(validMoves());
		this.setName("Bishop");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = super.getBishopMoves();
		this.setValid(moves);
		return moves;
	}
}
