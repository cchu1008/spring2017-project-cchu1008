package main.piece;
import java.util.List;

import main.helper.ImageType;
import main.helper.Position;

public class Rook extends Piece{
	private Position start;
	
	public Rook(Position p, boolean white, ImageType image){
		super(p, white, image);
		this.start = p;
		this.setValid(validMoves());
		this.setName(" Rook ");
	}
	
	public Position getStart(){
	  return this.start;
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = super.getRookMoves();
		this.setValid(moves);
		return moves;
	}
	
	 @Override
	  public boolean equals(Object obj){
	    Rook rook = (Rook)obj;
	    return super.equals(obj) && this.start.equals(rook.getStart());
	  }
}
