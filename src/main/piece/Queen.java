package main.piece;
import java.util.List;

import main.helper.ImageType;
import main.helper.Position;

public class Queen extends Piece{
	
	public Queen(Position p, boolean white, ImageType image){
		super(p, white, image);
		this.setValid(validMoves());
		this.setName(" Queen");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = super.getBishopMoves();
		moves.addAll(super.getRookMoves());
		
		this.setValid(moves);
		return moves;
	}
}
