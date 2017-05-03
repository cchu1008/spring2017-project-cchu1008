package main.driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;

import main.helper.Position;

public class Button extends MouseOverArea{
	private int row;
	private int col;
	private Player[] players;
	private int turn = 0;
	
	public Button(int row, int col, Player[] p, GameContainer container, Image image, int x, int y, int width, int height){
		super(container, image, x, y, width, height);
		this.row = row;
		this.col = col;
		this.players = p;
	}
	
	@Override
	public void mouseReleased(int button, int mx, int my){
		if(mx >= this.getX() && mx < (this.getX() + this.getWidth()) && my >= this.getY() && my < (this.getY() + this.getHeight())){
			super.mouseReleased(button, mx, my);
			players[turn].pickTile(new Position(this.row, this.col));
			System.out.println("Button clicked at (" + this.row + ", " + this.col + ")");
		}
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getCol(){
		return this.col;
	}
	
	public void setTurn(int i){
		this.turn = i;
	}
}
