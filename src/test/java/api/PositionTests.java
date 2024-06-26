package api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import api.domain.Dir;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import api.domain.Position;

class PositionTests {

	private Position position;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach                                         
    public void setUp() throws Exception {
    	position = new Position();
        System.setOut(new PrintStream(outputStreamCaptor));

    }
    
	@Test
    @DisplayName("When create a default Position object, Position should be 0,0,N")
	void checkGetPositionTest() {
		
		int x = position.getX();
		int y = position.getY();
		Dir dir = position.getDir();

		assertEquals(0, x,"X should be equal to 0");
		assertEquals(0, y,"y should be equal to 0");	
		assertEquals(Dir.N, dir,"Dir should be equal to N");	
	}
	@Test
    @DisplayName("When the Position is update with valid values, then should be a new position")
	void checkSetPositionTest() {
		
		position.setX(10);
		position.setX(0);

		position.setY(20);
		position.setY(0);

		position.setDir(Dir.W);
		
		int x = position.getX();
		int y = position.getY();
		Dir dir = position.getDir();

		assertEquals(0, x,"X should be equal to 0");
		assertEquals(0, y,"y should be equal to 0");
		assertEquals(Dir.W, dir,"Dir should be equal to W");	
	}

	@Test
	@DisplayName("When the Position is update with invalid values, then shouldn't be a new position")
	void checkSetBadPositionTest() {

		position.setX(10);
		position.setX(-1);

		position.setY(20);
		position.setY(-1);

		int x = position.getX();
		int y = position.getY();

		assertEquals(10, x,"X should be equal to 10");
		assertEquals(20, y,"y should be equal to 20");
	}
	
	@Test
    @DisplayName("When trying to backward to a value lower than 0, then X shouldn't change")
	void checkBackTest() {
		
		position.setX(0);
		position.backwardX();

		int x = position.getX();

		assertEquals(0, x,"X should be equal to 0");
	}

	@Test
	@DisplayName("When trying to forward to value upper than 0, then X should change")
	void checkForwBackTest() {

		position.setX(1);
		position.forwardX();

		int x = position.getX();

		assertEquals(2, x,"X should be equal to 2");
	}
	
	@Test
    @DisplayName("When upY to value upper than 0, then Y should change")
	void checkUpTest() {
		
		position.setY(0);
		position.upY();

		int y = position.getY();

		assertEquals(1, y,"y should be equal to 1");
	}

	@Test
	@DisplayName("When downY to value lower than 0, then Y shouldn't change")
	void checkDownTest() {

		position.setY(0);
		position.downY();

		int y = position.getY();

		assertEquals(0, y,"y should be equal to 1");
	}
	
	@Test
    @DisplayName("When print position, then should print in X Y Dir format")
	void checkPrintTest() {
			
		position.setX(20);
		position.setY(10);
		position.setDir(Dir.N);
		
		String expectedPrint = "20 10 N";
		position.print();
				
		assertEquals(expectedPrint, outputStreamCaptor.toString().trim());
	}

	@Test
	@DisplayName("When checkX to value lower than 0, then should return false")
	void checkBadXTest() {
		assertFalse(position.checkX(-1));
		assertFalse(position.checkX(-2));
	}

	@Test
	@DisplayName("When checkX to value upper or equal to 0, then should return true")
	void checkXTest() {
		assertTrue(position.checkX(0));
		assertTrue(position.checkX(100));
	}

	@Test
	@DisplayName("When checkY to value lower than 0, then should return false")
	void checkYTest() {
		assertFalse(position.checkY(-1));
		assertFalse(position.checkY(-2));
	}

	@Test
	@DisplayName("When checkY to value upper or equal to 0, then should return true")
	void checkBadYTest() {
		assertTrue(position.checkY(0));
		assertTrue(position.checkY(100));
	}

	@Test
	@DisplayName("When create a Position object with x>=0, y>=0, (N,E,S,W =>'Dir enum') values, then should works")
	void checkPositionConst2Test()  {

    	Position position = new Position(1,1,Dir.N);

		assertEquals(1, position.getX(),"X should be equal to 1");
		assertEquals(1, position.getY(),"Y should be equal to 1");
		assertEquals(Dir.N, position.getDir(),"Dir should be equal to N");

	}

	@Test
	@DisplayName("When create a Position object with not x>=0, y>=0, (N,E,S,W =>'Dir enum') values, then should return a default Position")
	void checkBadPositionConst2Test() {

		Position position = new Position(-1,1,Dir.N);

		assertEquals(0, position.getX(),"X should be equal to 0");
		assertEquals(0, position.getY(),"Y should be equal to 0");
		assertEquals(Dir.N, position.getDir(),"Dir should be equal to N");
    }

}
