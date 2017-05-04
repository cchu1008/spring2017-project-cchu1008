package main.piece;
import java.util.ArrayList;
import java.util.List;

import main.helper.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.GameDriver;

public abstract class Piece {
	private Position location;
	private ArrayList<Position> valid;
	private boolean white;
	private Image myImage;
	private String name;
	public GameDriver game;
	
	public Piece(Position p, boolean white, Image image, StateBasedGame game){
		this.location = p;
		this.white = white;
		this.myImage = image;
		this.game = (GameDriver)game;
	}
	
	public void move(Position p){
		this.setLocation(p);
		//validMoves();
	}
	
	public abstract List<Position> validMoves();
/**
	public List<Position> validMoves(){
		this.valid = new ArrayList<Position>();
		return this.valid;
	}
	**/
	public boolean isValid(Position point){
		boolean v = false;
		for(Position p : this.valid){
			if(p.equals(point)){
				v = true;
				break;
			}
		}
		return v;
	}
	public void setValid(List<Position> valid){
		this.valid = (ArrayList<Position>)valid;
	}
	public ArrayList<Position> getValid(){
		return this.valid;
	}
	public Position getLocation(){
		return this.location;
	}
	public void setLocation(Position p){
		this.location = p;
	}
	public boolean onBoard(Position p){
		return (p.getX() >= 0 && p.getX() < 8 && p.getY() >= 0 && p.getY() < 8);
	}
	public boolean isWhite(){
		return this.white;
	}
	public Image getImage(){
		return this.myImage;
	}
	public void printValid(){
		validMoves();
		for(Position p: this.valid){
			System.out.println("Valid: (" + p.getX() + ", " + p.getY() + ")");
		}
	}
	public String getName(){
		return this.name;
	}
	public void setName(String s){
		this.name = s;
	}
}
