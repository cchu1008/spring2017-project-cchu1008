package piece;
import java.util.List;

import helper.Position;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
public class Knight extends Piece{
	
	public Knight(Position p, boolean white, Image image, StateBasedGame game){
		super(p, white, image, game);
		this.setValid(validMoves());
		this.setName("Knight");
	}
	
	public ArrayList<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		
		//Note: Add checks for piece color in destination
		//Also add checks for this.game.board edge
		
		for(int i = -1; i < 2; i++){
			if(i == 0) continue;
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 2)) && (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + 2] == null || this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + 2].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + 2));
			
			if(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 2)) && (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - 2] == null || this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - 2].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - 2));
			
			if(onBoard(new Position(this.getLocation().getX() + 2, this.getLocation().getY() + i)) && (this.game.board[this.getLocation().getX() + 2][this.getLocation().getY() + i] == null || this.game.board[this.getLocation().getX() + 2][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + 2, this.getLocation().getY() + i));
			
			if(onBoard(new Position(this.getLocation().getX() - 2, this.getLocation().getY() + i)) && (this.game.board[this.getLocation().getX() - 2][this.getLocation().getY() + i] == null || this.game.board[this.getLocation().getX() - 2][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() - 2, this.getLocation().getY() + i));
		}
		this.setValid((ArrayList<Position>)moves);
		return (ArrayList<Position>)moves;
	}
}
