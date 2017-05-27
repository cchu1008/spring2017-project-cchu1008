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
	   if(obj == null)
	      return false;
	    
	    if(this.getClass() != obj.getClass())
	      return false;
	    
	    Rook p = (Rook)obj;
	    return this.getName() == p.getName() && this.isWhite() == p.isWhite() && this.getLocation() == p.getLocation()&& this.start.equals(p.getStart());
	  }
}
