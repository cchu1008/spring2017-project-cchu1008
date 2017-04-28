package piece;
import java.util.ArrayList;

import helper.*;
import org.newdawn.slick.Image;

public abstract class Piece {
	private Position location;
	private ArrayList<Position> valid;
	private boolean white;
	private Image myImage;
	public Piece[][] board;
	
	public Piece(Position p, boolean white, Image image, Piece[][] board){
		this.location = p;
		this.white = white;
		this.myImage = image;
		this.board = board;
	}
	
	public Piece(){
		this.location = new Position(0, 0);
	}
	
	public void move(Position p){
		if(isValid(p)) this.location = p;
	}
	public ArrayList<Position> validMoves(){
		return new ArrayList<Position>();
	}
	public boolean isValid(Position Position){
		return this.valid.contains(Position);
	}
	public void setValid(ArrayList<Position> valid){
		this.valid = valid;
	}
	public ArrayList<Position> getValid(){
		return this.valid;
	}
	public Position getLocation(){
		return this.location;
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
}
