package main.piece;
import java.util.ArrayList;
import java.util.List;

import main.helper.*;

import main.driver.GameDriver;

public abstract class Piece {
	private Position location;
	private ArrayList<Position> valid;
	private boolean white;
	private ImageType myImage;
	private String name;
	
	public Piece(Position p, boolean white, ImageType image){
		this.location = p;
		this.white = white;
		this.myImage = image;
	}
	
	public void move(Position p){
		this.setLocation(p);
	}
	
	public abstract List<Position> validMoves();

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
	public List<Position> getValid(){
		return this.valid;
	}
	
	public List<Position> getBishopMoves(){
		List<Position> moves = new ArrayList<>();
		int i = 1;
		
		int thisX = this.getLocation().getX();
		int thisY = this.getLocation().getY();
		//Up and Right
		while(onBoard(new Position(thisX + i, thisY - i))){
			if((GameDriver.getBoard()[thisX + i][thisY - i] == null) || (GameDriver.getBoard()[thisX + i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY - i));
			if(GameDriver.getBoard()[thisX + i][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Up and Left
		while(onBoard(new Position(thisX - i, thisY - i)) && ((GameDriver.getBoard()[thisX - i][thisY - i] == null) || (GameDriver.getBoard()[thisX - i][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.getBoard()[thisX - i][thisY - i] == null) || (GameDriver.getBoard()[thisX - i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY - i));
			if(GameDriver.getBoard()[thisX - i][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Down and Right
		while(onBoard(new Position(thisX + i, thisY + i)) && ((GameDriver.getBoard()[thisX + i][thisY + i] == null) || (GameDriver.getBoard()[thisX + i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.getBoard()[thisX + i][thisY + i] == null) || (GameDriver.getBoard()[thisX + i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY + i));
			if(GameDriver.getBoard()[thisX + i][thisY + i] != null)
				break;
			i++;
		}
		i = 1;
		//Down and Left
		while(onBoard(new Position(thisX - i, thisY + i)) && ((GameDriver.getBoard()[thisX - i][thisY + i] == null) || (GameDriver.getBoard()[thisX - i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.getBoard()[thisX - i][thisY + i] == null) || (GameDriver.getBoard()[thisX - i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY + i));
			if(GameDriver.getBoard()[thisX - i][thisY + i] != null)
				break;
			i++;
		}
		return moves;
	}
	
	public List<Position> getRookMoves(){
		List<Position> moves = new ArrayList<>();
		int i = 1;
		int thisX = this.getLocation().getX();
		int thisY = this.getLocation().getY();
		//Rook moves
		
		//Right
		while(onBoard(new Position(thisX + i, thisY))){
			if((GameDriver.getBoard()[thisX + i][thisY] == null) || (GameDriver.getBoard()[thisX + i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY));
			if(GameDriver.getBoard()[thisX + i][thisY] != null)
				break;
			i++;
		}
		i = 1;
		//Up
		while(onBoard(new Position(thisX, thisY - i)) && ((GameDriver.getBoard()[thisX][thisY - i] == null) || (GameDriver.getBoard()[thisX][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.getBoard()[thisX][thisY - i] == null) || (GameDriver.getBoard()[thisX][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY - i));
			if(GameDriver.getBoard()[thisX][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Down
		while(onBoard(new Position(thisX, thisY + i)) && ((GameDriver.getBoard()[thisX][thisY + i] == null) || (GameDriver.getBoard()[thisX][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.getBoard()[thisX][thisY + i] == null) || (GameDriver.getBoard()[thisX][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY + i));
			if(GameDriver.getBoard()[thisX][thisY + i] != null)
				break;
			i++;
		}
		i = 1;
		//Left
		while(onBoard(new Position(thisX - i, thisY)) && ((GameDriver.getBoard()[thisX - i][thisY] == null) || (GameDriver.getBoard()[thisX - i][thisY].isWhite() != this.isWhite()))){
			if((GameDriver.getBoard()[thisX - i][thisY] == null) || (GameDriver.getBoard()[thisX - i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY));
			if(GameDriver.getBoard()[thisX - i][thisY] != null)
				break;
			i++;
		}
		return moves;
	}
	
	public Position getLocation(){
		return this.location;
	}
	
	public void setLocation(Position p){
		this.location = p;
	}
	
	public boolean onBoard(Position p){
		return p.getX() >= 0 && p.getX() < 8 && p.getY() >= 0 && p.getY() < 8;
	}
	
	public boolean isWhite(){
		return this.white;
	}
	
	public ImageType getImage(){
		return this.myImage;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	@Override
	public boolean equals(Object obj){
	  if(obj == null)
	    return false;
	  
	  if(this.getClass() != obj.getClass())
	    return false;
	  
	  Piece p = (Piece)obj;
	  return this.hashCode() == p.hashCode() && this.name == p.getName();
	}
	
	@Override
	public int hashCode(){
	  int whiteInt = 0;
	  if(this.white)
	    whiteInt = 1;
	  return this.location.hashCode() * 13 + whiteInt;
	}
}
