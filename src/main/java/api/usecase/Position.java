package api.usecase;

enum Dir {
	  N,
	  E,
	  S,
	  W
}

public class Position {
	
	private int x;
	private int y;
	private Dir dir;
	
	public Position() {
		this.x=0;
		this.y=0;
		this.dir=Dir.N;
	}
	public Position(int x, int y, char dir) {
		
		if(checkXY(x,y) && checkDir(dir)) {
			this.x=x;
			this.y=y;
			this.dir=charToDir(dir);
		}
		
	}
	public Position(int x, int y, Dir dir) {
		if(checkXY(x,y)) {
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
	}
	
	public boolean checkXY(int x, int y) {
		if(x<0 || y<0) {
			return false;
		}
		return true;
	}
	public boolean checkDir(char dir) {
		switch (dir) 
	     {
	      case 'N':  
	      case 'E':  
	      case 'S':  
	      case 'W': 
	    	  return true;
	      default: 
	    	  return false;
	    }
	}
	
	public Dir charToDir(char dir) {
		Dir direction = Dir.N;
		switch (dir) 
	     {
	      case 'N':  
	    	  direction = Dir.N;
	      break;
	      case 'E':  
	    	  direction = Dir.E;
	      break; 
	      case 'S':  
	    	  direction = Dir.S;
	      break;
	      case 'W':  
	    	  direction = Dir.W;
	      break;
	    }
		return direction;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void forwardX(){
		this.x++;
	}
	public void backwardX(){
		this.x--;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void upY(){
		this.y++;
	}
	public void downY(){
		this.y--;
	}
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	public void print() {
		System.out.println(x + " " + y + " " + dir);
	}

}
