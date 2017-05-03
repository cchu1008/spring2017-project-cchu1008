package driver;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import piece.*;
import helper.*;

public class GameDriver extends StateBasedGame {
	public static final String GAME = "Chess";
	public static final int MENU = 0;
	public static final int SETUP = 1;
	public static final int PLAY = 2;
	public static final int END = 3;
	public static final int FPS = 160;
	public static final int X_SIZE = 700;
	public static final int Y_SIZE = 650;
	
	public Piece[][] board = new Piece[8][8];
	public Player[] players = new Player[2];
	
	public int turn = 0;
	
	public GameDriver(String name){
		super(name);
		this.addState(new Menu());
		this.addState(new Play());
		this.addState(new End());
		this.addState(new Setup());
	}
	
	public void move(Position start, Position end){
		Piece p = board[start.getX()][start.getY()];
		p.move(end);
		board[start.getX()][start.getY()] = null;
		board[end.getX()][end.getY()] = p;
		turn = (turn + 1)%2;
		printBoard();
	}
	
	public void update(Piece[][] b, Player x, Player y){
		this.board = b;
		this.players[0] = x;
		this.players[1] = y;
	}
	
	public boolean isEmpty(Position p){
		return (board[p.getX()][p.getY()] == null);
	}
	
	public void printBoard(){
		for(int i = 0; i < 8; i++){
			System.out.print("| ");
			for(int j = 0; j < 8; j++){
				if(!isEmpty(new Position(j, i))){
					board[j][i].setValid(board[j][i].validMoves());
					System.out.print(board[j][i].getName()  + " | ");
				}
				else System.out.print(" OOOO  | ");
			}
			System.out.println();
		}
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
		this.getState(MENU).init(container, this);
		this.enterState(MENU);

	}

}
