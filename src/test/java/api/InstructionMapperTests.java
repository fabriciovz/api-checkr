package api;

import static org.junit.jupiter.api.Assertions.*;

import api.domain.Dir;
import api.domain.Position;
import api.domain.mapper.InstructionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class InstructionMapperTests {

    private Position position;

    @BeforeEach
    public void setUp()  {
        position = new Position();

    }
    @Test
	@DisplayName("When checking coordinates in (N,E,S,W), should return true")
	void checkDirTest() {

		assertTrue(InstructionMapper.checkDir('N'));
		assertTrue(InstructionMapper.checkDir('E'));
		assertTrue(InstructionMapper.checkDir('S'));
		assertTrue(InstructionMapper.checkDir('W'));
	}

	@Test
	@DisplayName("When checking coordinates not in (N,E,S,W), should return false")
	void checkBadDirTest() {

		assertFalse(InstructionMapper.checkDir('Z'));
		assertFalse(InstructionMapper.checkDir('B'));
		assertFalse(InstructionMapper.checkDir('C'));
		assertFalse(InstructionMapper.checkDir('L'));
	}

    @Test
    @DisplayName("When translate chars in (N, E, S, W) to Dir enum, then should works")
    void checkCharToDirTest() {

        assertEquals(Dir.N, InstructionMapper.charToDir('N'),"dir should be equal to N");
        assertEquals(Dir.E, InstructionMapper.charToDir('E'),"dir should be equal to E");
        assertEquals(Dir.S, InstructionMapper.charToDir('S'),"dir should be equal to S");
        assertEquals(Dir.W, InstructionMapper.charToDir('W'),"dir should be equal to W");
    }

    @Test
    @DisplayName("When translate char not in (N, E, S, W) to Dir enum, then should be N")
    void checkBadCharToDirTest() {

        assertEquals(Dir.N, InstructionMapper.charToDir('Z'),"dir should be equal to N");
        assertEquals(Dir.N, InstructionMapper.charToDir('L'),"dir should be equal to E");
    }

    @Test
    @DisplayName("When convert a String of a number into an int value, then should works")
    void checkCharToIntTest() {

        assertEquals(1, InstructionMapper.charToInt("1"),"dir should be equal to N");
        assertEquals(12, InstructionMapper.charToInt("12"),"dir should be equal to N");
        assertEquals(0, InstructionMapper.charToInt("0"),"dir should be equal to N");

    }

    @Test
    @DisplayName("When a text has rows which elements are different to 1 or 3, then should be removed from the list")
    void checkCleanListTest() {

        String list= "5 5\n" +
                     "1 2 N\n" +
                     "LMLMLMLMM\n" +
                     "3 3 E\n" +
                     "MMRMMRMRRM\n";

        String expectedList= "1 3 N\n" +
                             "5 1 E\n";

        assertEquals(4, InstructionMapper.cleanList(list).size(),"dir should be equal to N");
    }

    @Test
    @DisplayName("When a text has sequentially rows (first coordinates and then command), then should return true")
    void checkIntegrityListTest() {
        List<String> list;

        String text= "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";


        list = InstructionMapper.cleanList(text);

        assertEquals(true,InstructionMapper.checkIntegrity(list) ,"dir should be equal to N");
    }

    @Test
    @DisplayName("When a text has not sequentially rows (first coordinates and then command), then should return false")
    void checkIntegrityBadListTest() {
        List<String> list;

        String text= "5 5\n" +
                "1 2 N\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";


        list = InstructionMapper.cleanList(text);

        assertEquals(false,InstructionMapper.checkIntegrity(list) ,"dir should be equal to N");
    }


}
