package driver;

public class Player {
	public String name;
	public boolean white;
	
	public Player(String name, boolean white){
		this.name = name;
		this.white = white;
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
