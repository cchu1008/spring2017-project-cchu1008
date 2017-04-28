package driver;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import piece.*;
import helper.*;

import java.util.ArrayList;

public class GameDriver extends StateBasedGame {
	public static final String GAME = "Chess";
	public static final int MENU = 0;
	public static final int SETUP = 1;
	public static final int PLAY = 2;
	public static final int END = 3;
	public static final int FPS = 70;
	public static final int X_SIZE = 600;
	public static final int Y_SIZE = 500;
	
	public Piece[][] board = new Piece[8][8];
	public Player p1 = new HumanPlayer("Player One", true, this);
	public Player p2 = new HumanPlayer("Player Two", false, this);
	
	public int turn = 0;
	
	public GameDriver(String name){
		super(name);
		this.addState(new Menu());
		this.addState(new Play());
		this.addState(new End());
		this.addState(new Setup());
	}
	
	public void update(Piece[][] b, Player x, Player y){
		this.board = b;
		this.p1 = x;
		this.p2 = y;
	}
	
	public boolean isEmpty(Position p){
		return (board[p.getX()][p.getY()] == null);
	}
	
	public ArrayList<Position> getValid(Piece p){
		ArrayList<Position> init = p.validMoves();
		Position Position;
		if((turn == 0 && p.isWhite() != p1.getWhite()) || (turn == 1 && p.isWhite() != p2.getWhite()))
			return null;
		
		for(int i = 0; i < init.size(); i++){
			Position = init.get(i);
			if(!isEmpty(Position)){
				if(board[Position.getX()][Position.getY()].isWhite() == p.isWhite())
					init.remove(i);
				//Horizontal movement
				if(Position.getX() == p.getLocation().getX()){
					if(Position.getY() > p.getLocation().getY()){
						while(init.get(++i).getY() > p.getLocation().getY() && init.get(i).getX() == p.getLocation().getX()){
							init.remove(i);
						}
					}
					else{
						while(init.get(++i).getY() < p.getLocation().getY() && init.get(i).getX() == p.getLocation().getX()){
							init.remove(i);
						}
					}
				}
				if(Position.getY() == p.getLocation().getY()){
					if(Position.getX() > p.getLocation().getX()){
						while(init.get(++i).getX() > p.getLocation().getX() && init.get(i).getY() == p.getLocation().getY()){
							init.remove(i);
						}
					}
					else{
						while(init.get(++i).getX() < p.getLocation().getX() && init.get(i).getY() == p.getLocation().getY()){
							init.remove(i);
						}
					}
				}
				
				//Diagonal movement (x - pos == y - pos)
				if(Math.abs(Position.getX() - p.getLocation().getX()) == Math.abs(Position.getY() - p.getLocation().getY())){
					if(Position.getX() - p.getLocation().getX() < 0){
						if(Position.getY() - p.getLocation().getY() > 0){
							while(init.get(++i).getX() < p.getLocation().getX() && init.get(i).getY() > p.getLocation().getY())
								init.remove(i);
						}
						else if(Position.getY() - p.getLocation().getY() < 0){
							while(init.get(i).getX() < p.getLocation().getX() && init.get(i).getY() < p.getLocation().getY())
								init.remove(i);
						}
					}
					else if(Position.getX() - p.getLocation().getX() > 0){
						if(Position.getY() - p.getLocation().getY() > 0){
							while(init.get(++i).getX() > p.getLocation().getX() && init.get(i).getY() > p.getLocation().getY())
								init.remove(i);
						}
						else if(Position.getY() - p.getLocation().getY() < 0){
							while(init.get(i).getX() > p.getLocation().getX() && init.get(i).getY() < p.getLocation().getY())
								init.remove(i);
						}
					}
				}
			}
			
		}
		
		p.setValid(init);
		return init;
	}
	
	public void movePiece(Position start, Position end){
		Piece p = board[start.getX()][start.getY()];
		ArrayList<Position> moves = getValid(p);
		if(p.onBoard(end) && moves.contains(end)){
			p.move(end);
			turn = (turn + 1)%2;
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
		this.getState(MENU).init(container,  this);
		this.enterState(MENU);

	}


}
