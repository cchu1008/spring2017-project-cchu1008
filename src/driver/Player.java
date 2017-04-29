package driver;

import org.newdawn.slick.state.StateBasedGame;

import helper.*;


public abstract class Player {
	public String name;
	private boolean white;
	public GameDriver game;
	private Position begin = null;
	private Position end = null;
	
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
	
	public void pickPiece(Position p){
		if(this.begin == null && this.game.board[p.getX()][p.getY()].isWhite() == this.isWhite())
			this.begin = p;
	}
	
	public void pickDestination(Position p){
		this.end = p;
	}
	
	public Position getStart(){
		return this.begin;
	}
	
	public Position getEnd(){
		return this.end;
	}
	
	public void resetPosition(){
		this.begin = null;
		this.end = null;
	}
	
}
