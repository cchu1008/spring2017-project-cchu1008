package main.driver;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

import main.piece.*;

public class Setup extends BasicGameState {
	
	public static final int ID = 1;
	
	private GameDriver game;
	private Piece[][] board;
	private Player[] players = new Player[2];
	
	Image face;
	int faceX = 300;
	int faceY = 300;
	
	public Setup(){
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.game = (GameDriver)game;
		this.board = this.game.board;
		this.players = this.game.players;
		
		face = new Image("resources/blackRook.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawString("This is the Setup State", GameDriver.X_SIZE*0.360f, GameDriver.Y_SIZE/8);
		g.setColor(Color.white);
		g.drawString("State Based Game Test", GameDriver.X_SIZE*0.365f, GameDriver.Y_SIZE/6);
		g.drawString("Numbers 0-3 will switch between states.", GameDriver.X_SIZE*0.255f, GameDriver.Y_SIZE/4);

		
		face.draw(faceX, faceY, 0.3f);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_UP)){
			faceY -= 2;
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			faceY += 2;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Setup.ID;
	}
	
	public void keyReleased(int key, char c){
		if(key == Input.KEY_RIGHT || key == Input.KEY_2){
			game.getState(Play.ID);
			game.enterState(Play.ID);
		}
		if(key == Input.KEY_LEFT || key == Input.KEY_0){
			game.getState(Menu.ID);
			game.enterState(Menu.ID);
		}
		if(key == Input.KEY_3){
			game.getState(End.ID);
			game.enterState(End.ID);
		}
	}

}
