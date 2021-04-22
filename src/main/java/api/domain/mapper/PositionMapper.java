package api.domain.mapper;

import api.domain.Dir;
import api.domain.Instruction;
import api.domain.Position;
import api.domain.Rover;
import java.util.ArrayList;
import java.util.List;

public class PositionMapper {

    public static boolean checkDir(char dir) {
        switch (dir)
        {
            case 'N':
            case 'E':
            case 'S':
            case 'W':
                return true;
            default:
                return false;
        }
    }

    public static Dir charToDir(char dir) {
        Dir direction;
        switch (dir)
        {
            case 'N':
                direction = Dir.N;
                break;
            case 'E':
                direction = Dir.E;
                break;
            case 'S':
                direction = Dir.S;
                break;
            case 'W':
                direction = Dir.W;
                break;
            default:
                direction = Dir.N;

        }
        return direction;
    }

    public int charToInt(String x){
        return Integer.parseInt(x);
    }

    public static List<Instruction> translateTextToCmd(String text)  {

        String lines[] = text.split("\\r?\\n");
        int linesLenght = lines.length;

        List<Instruction> instructionList = new ArrayList<>();;

        for (int i=1; i<linesLenght; i+=2) {

            String coordinates[] = lines[i-1].split(" ");
            String command = lines[i];

            PositionMapper mapper = new PositionMapper();

            int x= mapper.charToInt(coordinates[0]);
            int y=mapper.charToInt(coordinates[1]);
            char dir=coordinates[2].charAt(0);

            if(checkDir(dir)){

                Dir direction = charToDir(dir);
                Position position = new Position(x, y, direction);
                Rover rover = new Rover(position);

                instructionList.add(new Instruction(rover,command));
            }

        }
        return instructionList;
    }

}
