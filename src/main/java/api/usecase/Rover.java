package api.usecase;

public class Rover {

	Position postion;
	
	public Rover() {
		
	}
	
	public void setPosition(int x, int y, char dir) {
		Position position = new Position(x, y, dir);
		this.postion=position;
	}
	
	public void turnLeft() {
		
	}
	public void turnRight() {
		
	}
	public Position getPosition() {
		return this.postion;
	}
}
