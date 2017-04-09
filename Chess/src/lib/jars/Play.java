package lib.jars;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;

import Pieces.*;
import helper.*;

public class Play extends BasicGameState {
	
	public static final int ID = 1;

	public static Piece[][] board = new Piece[8][8];
	public static Player p1;
	public static Player p2;
	
	private StateBasedGame game;
	
	public Play(){
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
		this.game = game;
		

		generateWhite();
		generateBlack();
		
		//Get player name..?
		p1 = new Player("Player One", true);
		p2 = new Player("Player Two", false);

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.drawString("State Based Game Test", 205, 100);
		g.drawString("Numbers 0-2 will switch between states.", 125, 300);
		g.setColor(Color.red);
		g.drawString("This is State 1", 238, 50);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Play.ID;
	}
	
	public void keyReleased(int key, char c){
		if(key == Input.KEY_RIGHT){
			game.getState(End.ID);
			
			game.enterState(End.ID);
		}
		if(key == Input.KEY_LEFT){
			game.getState(Menu.ID);
			
			game.enterState(Menu.ID);
		}
	}
	
	
	public void generateWhite(){
		board[0][0] = new Rook(new Point(0, 0), true);
		board[7][0] = new Rook(new Point(7, 0), true);
		board[1][0] = new Knight(new Point(1, 0), true);
		board[6][0] = new Knight(new Point(6, 0), true);
		board[2][0] = new Bishop(new Point(2, 0), true);
		board[5][0] = new Bishop(new Point(5, 0), true);
		board[3][0] = new Queen(new Point(3, 0), true);
		board[4][0] = new King(new Point(4, 0), true);
	}
	
	public void generateBlack(){
		board[0][7] = new Rook(new Point(0, 7), false);
		board[7][7] = new Rook(new Point(7, 7), false);
		board[1][7] = new Knight(new Point(1, 7), false);
		board[6][7] = new Knight(new Point(6, 7), false);
		board[2][7] = new Bishop(new Point(2, 7), false);
		board[5][7] = new Bishop(new Point(5, 7), false);
		board[3][7] = new Queen(new Point(3, 7), false);
		board[4][7] = new King(new Point(4, 7), false);
		
	}

}
