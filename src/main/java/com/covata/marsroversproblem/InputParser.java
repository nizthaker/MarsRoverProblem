package com.covata.marsroversproblem;

import java.util.regex.Pattern;

public class InputParser {

    //creates plateau of input size
    public static Plateau parsePlateau(String input) {
        if(isValidPlateauInput(input)) {
            String[] coordinates = input.split(" ");
            return new Plateau(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }
        return null;
    }

    //creates position for rover
    public static Position parsePosition(String input) {
        if(isValidPositionInput(input)) {
            String[] positionArray = input.split(" ");
            int x = Integer.parseInt(positionArray[0]);
            int y = Integer.parseInt(positionArray[1]);
            Facing facing = Facing.getFacing(positionArray[2]);
            return new Position(x, y, facing);
        }
        return null;
    }

    //checks if input is in valid format for plateau
    private static Boolean isValidPlateauInput(String input) {
        if(Pattern.matches("[0-9]+ [0-9]+$", input)) {
            return true;
        }
        return false;
    }

    //checks if input is in valid format for position
    private static Boolean isValidPositionInput(String input) {
        if(Pattern.matches("[0-9]+ [0-9]+ [NEWS]$", input)) {
            return true;
        }
        return false;
    }
}
