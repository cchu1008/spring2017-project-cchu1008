package lib.jars;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import Pieces.*;
import helper.*;
import java.util.ArrayList;

public class GameDriver extends StateBasedGame {
	public static final String GAME = "Chess";
	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int END = 2;
	public static final int FPS = 70;
	public static final int X_SIZE = 600;
	public static final int Y_SIZE = 500;
	
	public Piece[][] board = new Piece[8][8];
	public Player p1 = new Player("Player One", true);
	public Player p2 = new Player("Player Two", false);
	
	public int turn = 0;
	
	public GameDriver(String name){
		super(name);
		this.addState(new Menu());
		this.addState(new Play());
		this.addState(new End());
	}
	
	public void update(Piece[][] b, Player x, Player y){
		this.board = b;
		this.p1 = x;
		this.p2 = y;
	}
	
	public boolean isEmpty(Point p){
		return (board[p.getX()][p.getY()] == null);
	}
	
	public ArrayList<Point> getValid(Piece p){
		ArrayList<Point> init = p.validMoves();
		Point point;
		if((turn == 0 && p.isWhite() != p1.getWhite()) || (turn == 1 && p.isWhite() != p2.getWhite()))
			return null;
		
		for(int i = 0; i < init.size(); i++){
			point = init.get(i);
			if(!isEmpty(point)){
				if(board[point.getX()][point.getY()].isWhite() == p.isWhite())
					init.remove(i);
				//Horizontal movement
				if(point.getX() == p.location.getX()){
					if(point.getY() > p.location.getY()){
						while(init.get(++i).getY() > p.location.getY() && init.get(i).getX() == p.location.getX()){
							init.remove(i);
						}
					}
					else{
						while(init.get(++i).getY() < p.location.getY() && init.get(i).getX() == p.location.getX()){
							init.remove(i);
						}
					}
				}
				if(point.getY() == p.location.getY()){
					if(point.getX() > p.location.getX()){
						while(init.get(++i).getX() > p.location.getX() && init.get(i).getY() == p.location.getY()){
							init.remove(i);
						}
					}
					else{
						while(init.get(++i).getX() < p.location.getX() && init.get(i).getY() == p.location.getY()){
							init.remove(i);
						}
					}
				}
				
				//Diagonal movement (x - pos == y - pos)
				if(Math.abs(point.getX() - p.location.getX()) == Math.abs(point.getY() - p.location.getY())){
					if(point.getX() - p.location.getX() < 0){
						if(point.getY() - p.location.getY() > 0){
							while(init.get(++i).getX() < p.location.getX() && init.get(i).getY() > p.location.getY())
								init.remove(i);
						}
						else if(point.getY() - p.location.getY() < 0){
							while(init.get(i).getX() < p.location.getX() && init.get(i).getY() < p.location.getY())
								init.remove(i);
						}
					}
					else if(point.getX() - p.location.getX() > 0){
						if(point.getY() - p.location.getY() > 0){
							while(init.get(++i).getX() > p.location.getX() && init.get(i).getY() > p.location.getY())
								init.remove(i);
						}
						else if(point.getY() - p.location.getY() < 0){
							while(init.get(i).getX() > p.location.getX() && init.get(i).getY() < p.location.getY())
								init.remove(i);
						}
					}
				}
			}
			
		}
		
		p.setValid(init);
		return init;
	}
	
	public void movePiece(Point start, Point end){
		Piece p = board[start.getX()][start.getY()];
		ArrayList<Point> moves = getValid(p);
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
