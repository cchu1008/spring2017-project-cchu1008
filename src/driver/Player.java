package driver;

import org.newdawn.slick.state.StateBasedGame;


public class Player {
	public String name;
	public boolean white;
	public GameDriver game;
	
	public Player(String name, boolean white, StateBasedGame game){
		this.name = name;
		this.white = white;
		this.game = (GameDriver) game;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setWhite(boolean white){
		this.white = white;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean getWhite(){
		return this.white;
	}
	
}
