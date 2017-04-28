package driver;

import org.newdawn.slick.state.StateBasedGame;

public class ComputerPlayer extends Player{
	public ComputerPlayer(StateBasedGame game){
		super("CPU", false, game);
	}
}
