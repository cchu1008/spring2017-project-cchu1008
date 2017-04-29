package driver;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import piece.*;

public class Menu extends BasicGameState {
	
	public static final int ID = 0;
	
	private GameDriver game;
	private Piece[][] board;
	private Player p1;
	private Player p2;
	
	
	public Menu(){
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
		this.game = (GameDriver)game;
		this.board = this.game.board;
		this.p1 = this.game.p1;
		this.p2 = this.game.p2;

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Image dark = new Image("resources/darkTile.jpg");
		Image light = new Image("resources/lightTile.jpg");
		Image playButton = new Image("resources/playButton.png");
		
		g.setBackground(Color.lightGray);
		
		g.setColor(Color.red);
		g.drawString("This is the Menu State", GameDriver.X_SIZE*0.360f, GameDriver.Y_SIZE/8);
		g.setColor(Color.white);
		g.drawString("State Based Game Test", GameDriver.X_SIZE*0.365f, GameDriver.Y_SIZE/6);
		g.drawString("Numbers 0-3 will switch between states.", GameDriver.X_SIZE*0.255f, GameDriver.Y_SIZE/4);
		
		dark.draw(GameDriver.X_SIZE*0.1f, GameDriver.Y_SIZE*0.1f, 0.1f);
		light.draw(GameDriver.X_SIZE*0.1f, GameDriver.Y_SIZE*0.2f, 0.1f);
		
		playButton.draw(GameDriver.X_SIZE*0.15f, GameDriver.Y_SIZE*0.5f, 0.1f);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if(posX > (GameDriver.X_SIZE*0.15f + 42) && posX < ((GameDriver.X_SIZE*0.15f + 42) + 376) && posY < (GameDriver.Y_SIZE*0.5f - 12) && posY > ((GameDriver.Y_SIZE*0.5f - 12) - 95)){
			if(Mouse.isButtonDown(0)){
				game.enterState(Setup.ID);
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Menu.ID;
	}
	
	public void keyReleased(int key, char c){
		if(key == Input.KEY_RIGHT || key == Input.KEY_1){
			game.getState(Setup.ID);
			game.enterState(Setup.ID);
		}
		if(key == Input.KEY_2){
			game.getState(Play.ID);
			game.enterState(Play.ID);
		}
		if(key == Input.KEY_3){
			game.getState(End.ID);
			game.enterState(End.ID);
		}
	}

}
