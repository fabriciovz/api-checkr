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
    @DisplayName("When create a Rover with a correct Position, then should works")
	void checkRoverConstTest() throws Exception {
    	Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(5, 7, Dir.S);

		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);

		assertEquals(1, rover.getPosition().getX(),"x should be equal to 1");
		assertEquals(2, rover.getPosition().getY(),"y should be equal to 2");
		assertEquals(Dir.N, rover.getPosition().getDir(),"Dir should be equal to N");

		assertEquals(5, rover2.getPosition().getX(),"x should be equal to 5");
		assertEquals(7, rover2.getPosition().getY(),"y should be equal to 7");
		assertEquals(Dir.S, rover2.getPosition().getDir(),"Dir should be equal to S");
	}
	@Test
    @DisplayName("When create a Rover and send it a correct command, then should works")
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

		assertEquals(Dir.E, rover.getPosition().getDir(),"Dir should be equal to E");
		assertEquals(Dir.W, rover2.getPosition().getDir(),"Dir should be equal to W");
		assertEquals(Dir.N, rover3.getPosition().getDir(),"Dir should be equal to N");
		assertEquals(Dir.E, rover4.getPosition().getDir(),"Dir should be equal to E");

	}

	@Test
	@DisplayName("When turn left The Rover, then should turn left its direction")
	void checkTurnLeftTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.W);
		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);

		rover.turnLeft();
		rover2.turnLeft();
		rover2.turnLeft();

		assertEquals(Dir.W, rover.getPosition().getDir(),"Dir should be equal to X");
		assertEquals(Dir.E, rover2.getPosition().getDir(),"Dir should be equal to E");
	}

	@Test
	@DisplayName("When turn right The Rover, then should turn right its direction")
	void checkTurnRightTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Position position2 = new Position(1, 2, Dir.W);
		Rover rover = new Rover(position);
		Rover rover2 = new Rover(position2);

		rover.turnRight();
		rover2.turnRight();
		rover2.turnRight();

		assertEquals(Dir.E, rover.getPosition().getDir(),"Dir should be equal to E");
		assertEquals(Dir.E, rover2.getPosition().getDir(),"Dir should be equal to E");
	}

	@Test
	@DisplayName("When move The Rover to North direction, then its Y position should be augmented by one")
	void checkMoveNTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);

		Rover rover = new Rover(position);

		rover.move();

		assertEquals(3, rover.getPosition().getY(),"Y should be equal to 3");
	}

	@Test
	@DisplayName("When move The Rover to South direction, then its Y position should be decreased by one")
	void checkMoveSTest() throws Exception {
		Position position = new Position(1, 2, Dir.S);
		Rover rover = new Rover(position);

		rover.move();
		assertEquals(1, rover.getPosition().getY(),"Y should be equal to 1");
	}

	@Test
	@DisplayName("When move The Rover to East direction, then its X position should be augmented by one")
	void checkMoveETest() throws Exception {
		Position position = new Position(1, 2, Dir.E);
		Rover rover = new Rover(position);

		rover.move();

		assertEquals(2, rover.getPosition().getX(),"X should be equal to 2");
	}

	@Test
	@DisplayName("When move The Rover to West direction, then its X position should be decreased by one")
	void checkMoveWTest() throws Exception {
		Position position = new Position(1, 2, Dir.W);
		Rover rover = new Rover(position);

		rover.move();
		assertEquals(0, rover.getPosition().getX(),"X should be equal to 0");
	}

	@Test
	@DisplayName("When translate L command in The Rover, then its Direction should turn to left")
	void checkTraslateLTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Rover rover = new Rover(position);

		rover.traslate('L');

		assertEquals(Dir.W, rover.getPosition().getDir(),"Dir should be equal to W");
	}

	@Test
	@DisplayName("When translate R command in The Rover, then its Direction should turn to right")
	void checkTraslateRTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Rover rover = new Rover(position);

		rover.traslate('R');

		assertEquals(Dir.E, rover.getPosition().getDir(),"Dir should be equal to E");
	}

	@Test
	@DisplayName("When translate M command in The Rover, then its Direction should keep the same")
	void checkTraslateMTest() throws Exception {
		Position position = new Position(1, 2, Dir.N);
		Rover rover = new Rover(position);

		rover.traslate('M');

		assertEquals(Dir.N, rover.getPosition().getDir(),"Dir should be equal to E");
	}

}
