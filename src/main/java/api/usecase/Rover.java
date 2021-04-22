package api.usecase;

public class Rover {

	Position postion;

	public Rover(Position position) {
		this.setPosition(position);
	}
	
	public void exec(String commands) {		
		char[] cmds = commands.toCharArray();

		for (char cmd : cmds) { 
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
	
	public void turnLeft() {
		Dir new_dir = (this.postion.getDir().ordinal() -1 < 0)?Dir.W: Dir.values()[(this.postion.getDir().ordinal() -1)] ;			
		this.postion.setDir(new_dir);
	}
	public void turnRight() {
		Dir new_dir = (this.postion.getDir().ordinal() + 1 > 3)?Dir.N: Dir.values()[(this.postion.getDir().ordinal() +1)] ;			
		this.postion.setDir(new_dir);
	}
	public Position getPosition() {
		return this.postion;
	}
	public void setPosition(Position position) {
		this.postion=position;
	}
}
