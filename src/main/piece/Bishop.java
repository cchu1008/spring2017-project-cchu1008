package main.piece;
import java.util.List;

import main.helper.Position;
import org.newdawn.slick.Image;

public class Bishop extends Piece{
	
	public Bishop(Position p, boolean white, Image image){
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
