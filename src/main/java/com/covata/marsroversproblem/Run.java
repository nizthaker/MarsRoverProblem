package com.covata.marsroversproblem;

import java.io.File;
import java.io.FileNotFoundException;

public class Run {
    public static void main(String[] args) {

        //reads input commands from file
        File file = new File("input.txt");
        ControlRover controlRover = new ControlRover(file);
        try {
            System.out.println(controlRover.getResults());
        } catch (FileNotFoundException e) {
            System.out.println("Please provide valid input file!");
        }

    }
}
