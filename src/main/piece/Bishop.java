package main.piece;
import java.util.List;
import java.util.ArrayList;
import main.helper.Position;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class Bishop extends Piece{
	
	public Bishop(Position p, boolean white, Image image, StateBasedGame game){
		super(p, white, image, game);
		this.setValid(validMoves());
		this.setName("Bishop");
	}
	
	public void move(Position p){
		this.setLocation(p);
		validMoves();
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<Position>();
		int i = 1;
		
		//Note: Add check for color of piece in destination
		
		//Up and Right
		while(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() - i))){
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() - i));
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() - i] != null))
				break;
			i++;
		}
		i = 1;
		//Up and Left
		while(onBoard(new Position(this.getLocation().getX() - i, this.getLocation().getY() - i)) && ((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() - i, this.getLocation().getY() - i));
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() - i] != null))
				break;
			i++;
		}
		i = 1;
		//Down and Right
		while(onBoard(new Position(this.getLocation().getX() + i, this.getLocation().getY() + i)) && ((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() + i, this.getLocation().getY() + i));
			if((this.game.board[this.getLocation().getX() + i][this.getLocation().getY() + i] != null))
				break;
			i++;
		}
		i = 1;
		//Down and Left
		while(onBoard(new Position(this.getLocation().getX() - i, this.getLocation().getY() + i)) && ((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i].isWhite() != this.isWhite()))){
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i] == null) || (this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i].isWhite() != this.isWhite()))
				moves.add(new Position(this.getLocation().getX() - i, this.getLocation().getY() + i));
			if((this.game.board[this.getLocation().getX() - i][this.getLocation().getY() + i] != null))
				break;
			i++;
		}
		this.setValid((ArrayList<Position>)moves);
		return moves;
	}
}
