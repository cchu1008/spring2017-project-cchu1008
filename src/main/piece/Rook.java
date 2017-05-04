package main.piece;
import java.util.List;

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
		List<Position> moves = super.getRookMoves();
		this.setValid(moves);
		return moves;
	}
}
