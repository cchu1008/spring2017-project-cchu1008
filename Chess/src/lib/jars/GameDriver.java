package lib.jars;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import Pieces.*;
import helper.*;

public class GameDriver extends BasicGame {
	public static Piece[][] board = new Piece[8][8];
	public static Player p1;
	public static Player p2;
	
	public GameDriver(String title){
		super(title);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		generateWhite();
		generateBlack();
		
		//Get player name..?
		p1 = new Player("Player One", true);
		p2 = new Player("Player Two", false);

	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub

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
