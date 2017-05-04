package main.driver;

import org.newdawn.slick.state.StateBasedGame;

import main.helper.*;
import main.piece.*;

public abstract class Player {
	public String name;
	private boolean white;
	public GameDriver game;
	private Position begin = new Position(-1, -1);
	private Position end = new Position(-1, -1);
	private Piece piece;
	
	public Player(String name, boolean white, StateBasedGame game){
		this.name = name;
		this.white = white;
		this.game = (GameDriver) game;
	}
	
	public void setWhite(boolean white){
		this.white = white;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isWhite(){
		return this.white;
	}
	
	public void pickTile(Position p){
		if(this.begin.equals(new Position(-1, -1)) && (this.game.board[p.getX()][p.getY()] != null) && (this.game.board[p.getX()][p.getY()].isWhite() == this.isWhite())){
			this.begin = p;
			this.piece = this.game.board[p.getX()][p.getY()];
			this.piece.printValid();

			System.out.println(this.name + " Begin: (" + this.begin.getX() + ", " + this.begin.getY() + ") ; End: (" + this.end.getX() + ", " + this.end.getY() + ")");
		}
		else if(!this.begin.equals(new Position(-1, -1)) && this.end.equals(new Position(-1, -1))){
			if(this.piece.isValid(p)){
				this.end = p;
				this.game.move(this.begin, this.end);
				System.out.println(this.name + " Begin: (" + this.begin.getX() + ", " + this.begin.getY() + ") ; End: (" + this.end.getX() + ", " + this.end.getY() + ")");
				resetPosition();
			}
			else if(!this.game.isEmpty(p) && this.game.board[p.getX()][p.getY()].isWhite() == this.isWhite()){
				this.begin = p;
				this.piece = this.game.board[p.getX()][p.getY()];
				this.piece.printValid();
				System.out.println(this.name + " Begin: (" + this.begin.getX() + ", " + this.begin.getY() + ") ; End: (" + this.end.getX() + ", " + this.end.getY() + ")");
			}
			else{
				System.out.println("Invalid move: (" + this.begin.getX() + ", " + this.begin.getY() + ") to (" + this.end.getX() + ", " + this.end.getY() + ")");
				resetPosition();
			}

		}
		else{
			System.out.println("Invalid move: (" + this.begin.getX() + ", " + this.begin.getY() + ") to (" + this.end.getX() + ", " + this.end.getY() + ")");
			resetPosition();
		}
	}
	
	public Position getStart(){
		return this.begin;
	}
	
	public Position getEnd(){
		return this.end;
	}
	
	public void resetPosition(){
		this.begin.setPos(-1, -1);
		this.end.setPos(-1, -1);
	}
	
}
