package api.domain;

public class Instruction {
    private Rover rover;
    private String command;

    public Instruction(Rover rover, String command){
        this.setRover(rover);
        this.setCommand(command);
    }
    public Rover getRover() {
        return rover;
    }
    public void setRover(Rover rover) {
        this.rover = rover;
    }
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
