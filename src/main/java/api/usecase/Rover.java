package api.usecase;

public class Rover {

	Position postion;
	
	public Rover() {
		
	}
	
	public void exec(String commands) {		
		char[] cmds = commands.toCharArray();
  		System.out.println(cmds.length);

		for (char cmd : cmds) { 
	  		System.out.println(cmd);

			traslate(cmd);
		}
	}
	public void traslate(char cmd) {
		switch (cmd) 
	     {
	      case 'L': 
	    	  this.turnLeft();
	      break;
	      case 'R':  
	    	  this.turnRight();
		  break;
	      case 'M': 
	    	  this.move();
		  break;
	    }
	}
	public void move() {
  		System.out.println("move");

		switch (this.postion.getDir()) {
		  case N:
	    	  this.postion.upY();
		      break;
	      case E:  
	    	  this.postion.forwardX();
		      break;
	      case S:
	    	  this.postion.downY();
		      break;
	      case W:
	    	  this.postion.backwardX();
		      break;
	    }
	}
	
	public void setPosition(int x, int y, char dir) {
		Position position = new Position(x, y, dir);
		this.postion=position;
	}
	
	public void turnLeft() {
  		System.out.println("left");

		Dir new_dir = (this.postion.getDir().ordinal() -1 < 0)?Dir.W: Dir.values()[(this.postion.getDir().ordinal() -1)] ;
						
		this.postion.setDir(new_dir);
	}
	public void turnRight() {
  		System.out.println("right");

		Dir new_dir = (this.postion.getDir().ordinal() + 1 > 3)?Dir.N: Dir.values()[(this.postion.getDir().ordinal() +1)] ;
						
		this.postion.setDir(new_dir);
		
	}
	public Position getPosition() {
		return this.postion;
	}
}
