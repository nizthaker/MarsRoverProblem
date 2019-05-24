package com.covata.marsroversproblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.covata.marsroversproblem.InputParser.parsePlateau;
import static com.covata.marsroversproblem.InputParser.parsePosition;

public class Run {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Rover> rovers = new ArrayList<>();

        //reads input commands from file
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        //creates plateau from first input line
        Plateau plateau = parsePlateau(scanner.nextLine());
        if(plateau == null) {
            System.out.println("Invalid input plateau");
            return;
        }

        while(scanner.hasNext()) {
            //reads next line for position
            Position position = parsePosition(scanner.nextLine());
            if(position == null) {
                System.out.println("Invalid input position");
                return;
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
                    return;
                }
            }
        }
        //prints each rover's final position
        rovers.forEach(r -> System.out.println(r.getPosition()));
    }
}
