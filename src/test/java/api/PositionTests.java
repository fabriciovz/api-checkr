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
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkGetPositionTest() {
		
		int x = position.getX();
		int y = position.getY();
		Dir dir = position.getDir();

		assertEquals(0, x,"X should be equal to 0");
		assertEquals(0, y,"y should be equal to 0");	
		assertEquals(Dir.N, dir,"Dir should be equal to N");	
	}
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkSetPositionTest() {
		
		position.setX(10);
		position.setY(20);
		position.setDir(Dir.W);
		
		int x = position.getX();
		int y = position.getY();
		Dir dir = position.getDir();

		assertEquals(10, x,"X should be equal to 10");
		assertEquals(20, y,"y should be equal to 20");	
		assertEquals(Dir.W, dir,"Dir should be equal to W");	
	}
	
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkForwBackTest() {
		
		position.setX(10);
		position.forwardX();
		position.forwardX();
		position.backwardX();
				
		int x = position.getX();

		assertEquals(11, x,"X should be equal to 11");	
	}
	
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkUpDownTest() {
		
		position.setY(10);
		position.upY();
		position.upY();
		position.downY();
				
		int y = position.getY();

		assertEquals(11, y,"y should be equal to 11");	
	}
	
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkPrintTest() {
			
		position.setX(20);
		position.setY(10);
		position.setDir(Dir.N);
		
		String expectedPrint = "20 10 N";
		position.print();
				
		assertEquals(expectedPrint, outputStreamCaptor.toString()
			      .trim(),"y should be equal to 11");	
	}
	
	@Test
    @DisplayName("Position should be 0,0,N when create a default Position object")   
	void checkCharToDirTest() {
			
		Dir dir = position.charToDir('N');
		Dir dir2 = position.charToDir('E');
		Dir dir3 = position.charToDir('S');
		Dir dir4 = position.charToDir('W');
		Dir dir5 = position.charToDir('P');

		assertEquals(Dir.N, dir,"y should be equal to 11");	
		assertEquals(Dir.E, dir2,"y should be equal to 11");
		assertEquals(Dir.S, dir3,"y should be equal to 11");
		assertEquals(Dir.W, dir4,"y should be equal to 11");
		assertEquals(Dir.N, dir5,"y should be equal to 11");

	}

	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkDirTest() {

		assertTrue(position.checkDir('N'));
		assertTrue(position.checkDir('E'));
		assertTrue(position.checkDir('S'));
		assertTrue(position.checkDir('W'));
		assertFalse(position.checkDir('Z'));

	}

	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkXYTest() {

		assertTrue(position.checkXY(2,5));
		assertTrue(position.checkXY(0,0));
		assertTrue(position.checkXY(10,10));
		assertFalse(position.checkXY(-1,5));
		assertFalse(position.checkXY(10,-1));
		assertFalse(position.checkXY(-1,-1));
	}

	@Test
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkPositionConst2Test()  {

		Exception exception = assertThrows(Exception.class, () -> {
			new Position(2,5,'Z');
		});

		Exception exception2 = assertThrows(Exception.class, () -> {
			new Position(-1,5,'N');
		});

		Exception exception3 = assertThrows(Exception.class, () -> {
			new Position(1,-1,'N');
		});

		assertDoesNotThrow(() -> {
			new Position(1,1,'N');
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
	@DisplayName("Position should be 0,0,N when create a default Position object")
	void checkPositionConst3Test()  {

		String expectedMessage = "Incorrect arguments";

		Exception exception = assertThrows(Exception.class, () -> {
			new Position(-1,1,Dir.N);
		});

		Exception exception2 = assertThrows(Exception.class, () -> {
			new Position(1,-1,Dir.N);
		});

		assertDoesNotThrow(() -> {
			new Position(1,1,Dir.N);
		});

		String actualMessage = exception.getMessage();
		String actualMessage2 = exception2.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
		assertTrue(actualMessage2.contains(expectedMessage));
	}

}
