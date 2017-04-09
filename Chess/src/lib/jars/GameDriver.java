package lib.jars;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;


public class GameDriver extends StateBasedGame {
	public static final String GAME = "Chess";
	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int END = 2;
	public static final int FPS = 70;
	public static final int X_SIZE = 600;
	public static final int Y_SIZE = 500;
	
	public GameDriver(String name){
		super(name);
		this.addState(new Play());
		this.addState(new Menu());
		this.addState(new End());
	}
	
	public static void main(String[] args){
		try{
			AppGameContainer container = new AppGameContainer(new GameDriver(GAME));
			container.setDisplayMode(X_SIZE, Y_SIZE, false);
			container.setTargetFrameRate(FPS);
			container.start();
		}
		catch (SlickException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(MENU).init(container,  this);
		this.enterState(MENU);

	}


}
