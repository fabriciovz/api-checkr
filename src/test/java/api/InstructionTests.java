package api;

import api.domain.Dir;
import api.domain.Instruction;
import api.domain.Position;
import api.domain.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTests {

    private Rover rover;
    private Position position;
    private Instruction instruction;

    @BeforeEach
    public void setUp() {
        position = new Position(1, 2, Dir.N);
        rover = new Rover(position);
    }

    @Test
    @DisplayName("When set a command, then getCommand should return the same command")
    void checkSetGetCmdTest() {

        instruction = new Instruction(rover,"");

        String command = "LMMMM";
        instruction.setCommand(command);

        assertEquals(instruction.getCommand(), command);
    }

    @Test
    @DisplayName("When set a Rover, then getRover should return the same Rover")
    void checkSetGetRoverTest() {

        instruction = new Instruction(rover,"LMMMM");
        position = new Position(50, 2, Dir.N);

        Rover rover2 = new Rover(position);
        instruction.setRover(rover2);

        assertSame(instruction.getRover(), rover2);
        assertNotSame(instruction.getRover(),rover);
    }

}