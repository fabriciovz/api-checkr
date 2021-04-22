package api;

import api.usecase.Dir;
import api.usecase.Position;
import api.usecase.Rover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTests {

	private Rover rover;
    
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkRoverConstTest() throws Exception {

    	Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(5, 7, Dir.S);

		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);

		assertEquals(1, rover.getPosition().getX(),"X should be equal to 0");
		assertEquals(2, rover.getPosition().getY(),"X should be equal to 0");
		assertEquals(Dir.N, rover.getPosition().getDir(),"X should be equal to 0");

		assertEquals(5, rover2.getPosition().getX(),"X should be equal to 0");
		assertEquals(7, rover2.getPosition().getY(),"X should be equal to 0");
		assertEquals(Dir.S, rover2.getPosition().getDir(),"X should be equal to 0");
	}
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkExecTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.N);
		Position position3 = new Position(1, 2, Dir.N);
		Position position4 = new Position(3, 3, Dir.E);

		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);
		Rover rover3 = new Rover(position3);
		Rover rover4 = new Rover(position4);

		rover.exec("LLL");
		rover2.exec("RRR");
		rover3.exec("LMLMLMLMM");
		rover4.exec("MMRMMRMRRM");

		assertEquals(Dir.E, rover.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.W, rover2.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.N, rover3.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.E, rover4.getPosition().getDir(),"X should be equal to 0");

	}
	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkTurnLeftTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.W);
		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);

		rover.turnLeft();
		rover2.turnLeft();
		rover2.turnLeft();

		assertEquals(Dir.W, rover.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.E, rover2.getPosition().getDir(),"X should be equal to 0");
	}

	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkTurnRightTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.W);
		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);

		rover.turnRight();
		rover2.turnRight();
		rover2.turnRight();

		assertEquals(Dir.E, rover.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.E, rover2.getPosition().getDir(),"X should be equal to 0");
	}

	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkMoveTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.W);
		Position position3 = new Position(1, 2, Dir.S);
		Position position4 = new Position(1, 2, Dir.E);

		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);
		Rover rover3 = new Rover(position3);
		Rover rover4 = new Rover(position4);

		rover.move();
		rover2.move();
		rover3.move();
		rover4.move();

		assertEquals(3, rover.getPosition().getY(),"X should be equal to 0");
		assertEquals(0, rover2.getPosition().getX(),"X should be equal to 0");
		assertEquals(1, rover3.getPosition().getY(),"X should be equal to 0");
		assertEquals(2, rover4.getPosition().getX(),"X should be equal to 0");
	}

	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkTraslateTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.W);
		Position position3 = new Position(1, 2, Dir.S);

		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);
		Rover rover3 = new Rover(position3);

		rover.traslate('L');
		rover2.traslate('R');
		rover3.traslate('M');

		assertEquals(Dir.W, rover.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.N, rover2.getPosition().getDir(),"X should be equal to 0");
		assertEquals(Dir.S, rover3.getPosition().getDir(),"X should be equal to 0");

	}

}
