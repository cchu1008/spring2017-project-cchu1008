package main.piece;
import java.util.ArrayList;
import java.util.List;

import main.helper.*;
import org.newdawn.slick.Image;

import main.driver.GameDriver;

public abstract class Piece {
	private Position location;
	private ArrayList<Position> valid;
	private boolean white;
	private Image myImage;
	private String name;
	public GameDriver game;
	
	public Piece(Position p, boolean white, Image image){
		this.location = p;
		this.white = white;
		this.myImage = image;
		//this.game = (GameDriver)game;
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
			if((GameDriver.board[thisX + i][thisY - i] == null) || (GameDriver.board[thisX + i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY - i));
			if(GameDriver.board[thisX + i][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Up and Left
		while(onBoard(new Position(thisX - i, thisY - i)) && ((GameDriver.board[thisX - i][thisY - i] == null) || (GameDriver.board[thisX - i][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY - i] == null) || (GameDriver.board[thisX - i][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY - i));
			if(GameDriver.board[thisX - i][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Down and Right
		while(onBoard(new Position(thisX + i, thisY + i)) && ((GameDriver.board[thisX + i][thisY + i] == null) || (GameDriver.board[thisX + i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX + i][thisY + i] == null) || (GameDriver.board[thisX + i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY + i));
			if(GameDriver.board[thisX + i][thisY + i] != null)
				break;
			i++;
		}
		i = 1;
		//Down and Left
		while(onBoard(new Position(thisX - i, thisY + i)) && ((GameDriver.board[thisX - i][thisY + i] == null) || (GameDriver.board[thisX - i][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY + i] == null) || (GameDriver.board[thisX - i][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY + i));
			if(GameDriver.board[thisX - i][thisY + i] != null)
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
			if((GameDriver.board[thisX + i][thisY] == null) || (GameDriver.board[thisX + i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX + i, thisY));
			if(GameDriver.board[thisX + i][thisY] != null)
				break;
			i++;
		}
		i = 1;
		//Up
		while(onBoard(new Position(thisX, thisY - i)) && ((GameDriver.board[thisX][thisY - i] == null) || (GameDriver.board[thisX][thisY - i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX][thisY - i] == null) || (GameDriver.board[thisX][thisY - i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY - i));
			if(GameDriver.board[thisX][thisY - i] != null)
				break;
			i++;
		}
		i = 1;
		//Down
		while(onBoard(new Position(thisX, thisY + i)) && ((GameDriver.board[thisX][thisY + i] == null) || (GameDriver.board[thisX][thisY + i].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX][thisY + i] == null) || (GameDriver.board[thisX][thisY + i].isWhite() != this.isWhite()))
				moves.add(new Position(thisX, thisY + i));
			if(GameDriver.board[thisX][thisY + i] != null)
				break;
			i++;
		}
		i = 1;
		//Left
		while(onBoard(new Position(thisX - i, thisY)) && ((GameDriver.board[thisX - i][thisY] == null) || (GameDriver.board[thisX - i][thisY].isWhite() != this.isWhite()))){
			if((GameDriver.board[thisX - i][thisY] == null) || (GameDriver.board[thisX - i][thisY].isWhite() != this.isWhite()))
				moves.add(new Position(thisX - i, thisY));
			if(GameDriver.board[thisX - i][thisY] != null)
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
