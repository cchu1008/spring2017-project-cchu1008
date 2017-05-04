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
		String normal = this.name + " Begin: (" + this.begin.getX() + ", " + this.begin.getY() + ") ; End: (" + this.end.getX() + ", " + this.end.getY() + ")";
		String invalid = "Invalid move: (" + this.begin.getX() + ", " + this.begin.getY() + ") to (" + this.end.getX() + ", " + this.end.getY() + ")";
		
		if(this.begin.equals(new Position(-1, -1)) && (GameDriver.board[p.getX()][p.getY()] != null) && (GameDriver.board[p.getX()][p.getY()].isWhite() == this.isWhite())){
			this.begin = p;
			this.piece = GameDriver.board[p.getX()][p.getY()];
			this.piece.printValid();

			System.out.println(normal);
		}
		else if(!this.begin.equals(new Position(-1, -1)) && this.end.equals(new Position(-1, -1))){
			if(this.piece.isValid(p)){
				this.end = p;
				GameDriver.move(this.begin, this.end);
				System.out.println(normal);
				resetPosition();
			}
			else if(!GameDriver.isEmpty(p) && GameDriver.board[p.getX()][p.getY()].isWhite() == this.isWhite()){
				this.begin = p;
				this.piece = GameDriver.board[p.getX()][p.getY()];
				this.piece.printValid();
				System.out.println(normal);
			}
			else{
				System.out.println(invalid);
				resetPosition();
			}

		}
		else{
			System.out.println(invalid);
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
