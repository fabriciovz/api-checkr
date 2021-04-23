package api.domain.mapper;

import api.domain.Dir;
import api.domain.Instruction;
import api.domain.Position;
import api.domain.Rover;
import java.util.ArrayList;
import java.util.List;

public class InstructionMapper {
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

    public static int charToInt(String x){
        return Integer.parseInt(x);
    }

    public static List<Instruction> translateTextToCmd(String text)  {

        List<String> list = cleanList(text);
        if(checkIntegrity(list)) {
            List<Instruction> instructionList = new ArrayList<>();
            for (int i = 1; i < list.size(); i += 2) {
                String command = list.get(i);
                Position position = translateTextToPosition(list.get(i - 1));
                if (position != null) {
                    Rover rover = new Rover(position);
                    instructionList.add(new Instruction(rover, command));
                }
            }
            return instructionList;
        }
        return null;
    }

    public static Position translateTextToPosition(String text)  {
        String coordinates[] = text.split(" ");
        if(coordinates.length==3) {
            int x = charToInt(coordinates[0]);
            int y = charToInt(coordinates[1]);
            char dir = coordinates[2].charAt(0);

            if (checkDir(dir)) {
                Dir direction = charToDir(dir);
                Position position = new Position(x, y, direction);
                return position;
            }
        }
        return null;
    }

    public static List<String> cleanList(String text) {
        String lines[] = text.split("\\r?\\n");
        List<String> list = new ArrayList<>();;
        for (int i=0; i<lines.length; i++) {
            String line[] = lines[i].split(" ");
            switch (line.length)
            {
                case 1:
                case 3:
                    list.add(lines[i]);
            }
        }
        return list;
    }
    public static boolean checkIntegrity(List<String> list) {
        for (int i=1; i<list.size(); i+=2) {
            String lineI[] = list.get(i-1).split(" ");
            String line2[] = list.get(i).split(" ");
            if (!(lineI.length==3 && line2.length==1)){
                return false;
            }
        }
        return true;
    }
}
