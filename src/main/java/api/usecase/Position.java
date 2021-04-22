package api.usecase;

public class Position {
	
	private int x;
	private int y;
	private Dir dir;
	
	public Position() {
		this.x=0;
		this.y=0;
		this.dir=Dir.N;
	}
	public Position(int x, int y, char dir) throws Exception {
		
		if(checkX(x) && checkY(y) && checkDir(dir)) {
			this.x=x;
			this.y=y;
			this.dir=charToDir(dir);
		}
		else {
			throw new Exception("Incorrect arguments");
		}
	}
	public Position(int x, int y, Dir dir) throws Exception {
		if(checkX(x) && checkY(y)) {
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
		else {
			throw new Exception("Incorrect arguments");
		}
	}

	public boolean checkX(int x) {
		if(x<0) {
			return false;
		}
		return true;
	}
	public boolean checkY(int y) {
		if(y<0) {
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
		Dir direction;
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
	      default:
			  direction = Dir.N;

		 }
		return direction;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if(this.checkX(x)) {
			this.x = x;
		}
	}
	public void forwardX(){
		this.x++;
	}
	public void backwardX(){
		if(this.checkX(this.getX()-1)) {
			this.x--;
		}
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		if(this.checkY(y)) {
			this.y = y;
		}
	}
	public void upY(){
		this.y++;
	}
	public void downY(){
		if(this.checkY(this.getY()-1)) {
			this.y--;
		}
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
