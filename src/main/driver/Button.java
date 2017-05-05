package main.driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;

import main.helper.*;

public class Button extends MouseOverArea{
	private int row;
	private int col;
	private Player[] players;
	
	public Button(int row, int col, Player[] p, GameContainer container, Image image, int x, int y, int width, int height){
		super(container, image, x, y, width, height);
		this.row = row;
		this.col = col;
		this.players = p;
	}
	
	@Override
	public void mouseReleased(int button, int mx, int my){
		if(isMouseOver()){
			super.mouseReleased(button, mx, my);
			players[GameDriver.turn].pickTile(new Position(this.row, this.col));
			System.out.println("Button clicked at (" + this.row + ", " + this.col + ")");
		}
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getCol(){
		return this.col;
	}
}
