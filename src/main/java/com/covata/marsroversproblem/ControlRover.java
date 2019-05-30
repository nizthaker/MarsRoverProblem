package com.covata.marsroversproblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.covata.marsroversproblem.InputParser.parsePlateau;
import static com.covata.marsroversproblem.InputParser.parsePosition;

public class ControlRover {
    File file;
    ArrayList<Rover> rovers = new ArrayList<>();

    public ControlRover(File file) {
        this.file = file;
    }

    public final File getInputFile() {
        return file;
    }

    public String getResults() throws FileNotFoundException {

        file = getInputFile();
        Scanner scanner = new Scanner(file);

        //creates plateau from first input line
        Plateau plateau = parsePlateau(scanner.nextLine());
        if(plateau == null) {
               System.out.println("Invalid input plateau");
        }

        while(scanner.hasNext()) {

            //reads next line for position
            Position position = parsePosition(scanner.nextLine());
            if(position == null) {
                System.out.println("Invalid input position");
            }

            //creates rover
            Rover rover = new Rover(plateau, position);
            //add rover to the list
            rovers.add(rover);

            if(scanner.hasNext()) {
                //reads string of commands from next line
                String commands = scanner.nextLine();
                //checks if commands are valid
                if (rover.validateCommand(commands)) {
                    //execute commands on rover
                    rover.execute(commands);
                } else {
                    System.out.println("Invalid input command");
                }
            }
        }
        return getOutputString(rovers);
    }

    private static String getOutputString(List<Rover> rovers) {
        String output = "";
        int noOfRovers = rovers.size();
        for(int i = 0; i < noOfRovers; i++) {
            output += getOutputString(rovers.get(i)) + (i+1 < noOfRovers ? "\n" : "" );
        }
        return output;
    }

    private static String getOutputString(Rover rover) {
        return rover.getPosition().toString();
    }
}