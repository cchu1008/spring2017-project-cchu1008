package driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;

import helper.*;
import piece.*;

public class Play extends BasicGameState {
	
	public static final int ID = 1;

	private GameDriver game;
	private Piece[][] board;
	private Player p1;
	private Player p2;
	
	private int turn;
	
	public Play(){
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
		this.game = (GameDriver)game;
		this.board = this.game.board;
		this.p1 = this.game.p1;
		this.p2 = this.game.p2;
		this.turn = this.game.turn;
		

		generateWhite();
		generateBlack();
		
		//Get player name..?
		p1 = new Player("Player Seven", true, this.game);
		p2 = new Player("Player Eight", false, this.game);
		
		this.game.update(board, p1, p2);

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawString("This is the Play State", 220, 50);
		g.setColor(Color.white);
		g.drawString("State Based Game Test", 205, 100);
		g.drawString("Numbers 0-2 will switch between states.", 125, 200);
		g.drawString("Player 1: ", GameDriver.X_SIZE/3, GameDriver.Y_SIZE/3);
		g.drawString(this.game.p1.getName(), GameDriver.X_SIZE/3 + 100, GameDriver.Y_SIZE/3);
		g.drawString("Player 2: ", GameDriver.X_SIZE/3, GameDriver.Y_SIZE/2);
		g.drawString(this.game.p2.getName(), GameDriver.X_SIZE/3 + 100, GameDriver.Y_SIZE/2);

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
		if(key == Input.KEY_RIGHT || key == Input.KEY_2){
			game.getState(End.ID);
			game.enterState(End.ID);
		}
		if(key == Input.KEY_LEFT || key == Input.KEY_0){
			game.getState(Menu.ID);
			game.enterState(Menu.ID);
		}
	}
	
	
	public void generateWhite(){
		board[0][0] = new Rook(new Position(0, 0), true);
		board[7][0] = new Rook(new Position(7, 0), true);
		board[1][0] = new Knight(new Position(1, 0), true);
		board[6][0] = new Knight(new Position(6, 0), true);
		board[2][0] = new Bishop(new Position(2, 0), true);
		board[5][0] = new Bishop(new Position(5, 0), true);
		board[3][0] = new Queen(new Position(3, 0), true);
		board[4][0] = new King(new Position(4, 0), true);
	}
	
	public void generateBlack(){
		board[0][7] = new Rook(new Position(0, 7), false);
		board[7][7] = new Rook(new Position(7, 7), false);
		board[1][7] = new Knight(new Position(1, 7), false);
		board[6][7] = new Knight(new Position(6, 7), false);
		board[2][7] = new Bishop(new Position(2, 7), false);
		board[5][7] = new Bishop(new Position(5, 7), false);
		board[3][7] = new Queen(new Position(3, 7), false);
		board[4][7] = new King(new Position(4, 7), false);
		
	}

}
