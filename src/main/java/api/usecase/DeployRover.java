package api.usecase;

import api.domain.Instruction;
import api.domain.Rover;
import api.domain.mapper.PositionMapper;

import java.util.List;

public class DeployRover {
    public String deploy(String text){
        List<Instruction> instructionList = PositionMapper.translateTextToCmd(text);
        String resultList = "";
        for (Instruction instruction: instructionList){
            Rover rover = instruction.getRover();
            String command = instruction.getCommand();
            rover.exec(command);
            resultList += rover.getPosition().getPrintFormat() + "\n";
        }
        return resultList;
    }
}
