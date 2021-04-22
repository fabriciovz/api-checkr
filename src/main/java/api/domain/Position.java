package api.domain;

import api.domain.Dir;

public class Position {
	
	private int x;
	private int y;
	private Dir dir;
	
	public Position() {
		this.x=0;
		this.y=0;
		this.dir=Dir.N;
	}
	public Position(int x, int y, Dir dir) {
		if(checkX(x) && checkY(y)) {
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
		else {
			new Position();
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
		System.out.println(getPrintFormat());
	}
	public String getPrintFormat(){
		return x + " " + y + " " + dir;
	}

}
