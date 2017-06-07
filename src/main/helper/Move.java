package main.helper;

public class Move {
  private Position start;
  private Position end;

  public Move(Position start, Position end) {
    this.start = start;
    this.end = end;
  }
  
  public Position getStart(){
    return this.start;
  }
  
  public Position getEnd(){
    return this.end;
  }
  
  @Override
  public boolean equals(Object obj) {
    if(obj == null)
      return false;
    
    if(this.getClass() != obj.getClass())
      return false;
    
    Move p = (Move)obj;
    return this.hashCode() == p.hashCode();
  }
  
  @Override
  public int hashCode(){
    return this.getStart().hashCode() * 7 + this.getEnd().hashCode();
  }

}
