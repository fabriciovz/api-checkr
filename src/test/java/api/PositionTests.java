package api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import api.usecase.*;
import api.usecase.Position;

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
    @DisplayName("When translate chars in (N, E, S, W) to Dir enum, then should works")
	void checkCharToDirTest() {
		Dir dir = position.charToDir('N');
		Dir dir2 = position.charToDir('E');
		Dir dir3 = position.charToDir('S');
		Dir dir4 = position.charToDir('W');

		assertEquals(Dir.N, dir,"dir should be equal to N");
		assertEquals(Dir.E, dir2,"dir2 should be equal to E");
		assertEquals(Dir.S, dir3,"dir3 should be equal to S");
		assertEquals(Dir.W, dir4,"dir4 should be equal to W");
	}

	@Test
	@DisplayName("When translate char not in (N, E, S, W) to Dir enum, then shouldn't works")
	void checkBadCharToDirTest() {
		Dir dir = position.charToDir('Z');
		Dir dir2 = position.charToDir('B');

		assertEquals(Dir.N, dir,"dir should be equal to N");
		assertEquals(Dir.N, dir2,"dir2 should be equal to N");
	}

	@Test
	@DisplayName("When checking coordinates in (N,E,S,W), should return true")
	void checkDirTest() {

		assertTrue(position.checkDir('N'));
		assertTrue(position.checkDir('E'));
		assertTrue(position.checkDir('S'));
		assertTrue(position.checkDir('W'));
	}

	@Test
	@DisplayName("When checking coordinates not in (N,E,S,W), should return false")
	void checkBadDirTest() {

		assertFalse(position.checkDir('Z'));
		assertFalse(position.checkDir('B'));
		assertFalse(position.checkDir('C'));
		assertFalse(position.checkDir('L'));
	}

	@Test
	@DisplayName("When checkX to value lower than 0, then should return false")
	void checkXTest() {
		assertFalse(position.checkX(-1));
		assertFalse(position.checkX(-2));
	}

	@Test
	@DisplayName("When checkX to value upper or equal to 0, then should return true")
	void checkBadXTest() {
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
	@DisplayName("When create a Position object with x>=0, y>=0, (N,E,S,W =>'char') values, then shouldn't return an exception")
	void checkPositionConst2Test()  {

		assertDoesNotThrow(() -> {
			new Position(1,1,'N');
		});

		assertDoesNotThrow(() -> {
			new Position(0,10,'W');
		});
	}


	@Test
	@DisplayName("When create a Position object with not x>=0, y>=0, (N,E,S,W =>'char')  values, then should return an exception")
	void checkBadPositionConst2Test()  {

		Exception exception = assertThrows(Exception.class, () -> {
			new Position(2,5,'Z');
		});

		Exception exception2 = assertThrows(Exception.class, () -> {
			new Position(-1,5,'N');
		});

		Exception exception3 = assertThrows(Exception.class, () -> {
			new Position(1,-1,'N');
		});

		String expectedMessage = "Incorrect arguments";

		String actualMessage = exception.getMessage();
		String actualMessage2 = exception2.getMessage();
		String actualMessage3 = exception3.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
		assertTrue(actualMessage2.contains(expectedMessage));
		assertTrue(actualMessage3.contains(expectedMessage));
	}


	@Test
	@DisplayName("When create a Position object with x>=0, y>=0, (N,E,S,W =>'Dir enum') values, then shouldn't return an exception")
	void checkPositionConst3Test()  {

		assertDoesNotThrow(() -> {
			new Position(1,1,Dir.N);
		});

		assertDoesNotThrow(() -> {
			new Position(3,50,Dir.E);
		});
	}

	@Test
	@DisplayName("When create a Position object with not x>=0, y>=0  values, then should return an exception")
	void checkBadPositionConst3Test()  {

		String expectedMessage = "Incorrect arguments";

		Exception exception = assertThrows(Exception.class, () -> {
			new Position(-1,1,Dir.N);
		});

		Exception exception2 = assertThrows(Exception.class, () -> {
			new Position(1,-1,Dir.E);
		});

		String actualMessage = exception.getMessage();
		String actualMessage2 = exception2.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
		assertTrue(actualMessage2.contains(expectedMessage));
	}

}
