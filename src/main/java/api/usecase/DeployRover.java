package api.usecase;

import api.domain.Instruction;
import api.domain.Rover;
import api.domain.mapper.InstructionMapper;

import java.util.List;

public class DeployRover {
    public String deploy(String text){
        List<Instruction> instructionList = InstructionMapper.translateTextToCmd(text);
        if(instructionList==null){
            return "Please check instructions integrity";
        }
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
