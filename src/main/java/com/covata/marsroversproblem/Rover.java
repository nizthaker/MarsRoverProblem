package com.covata.marsroversproblem;

import java.util.regex.Pattern;


public class Rover {
    //current position of rover
    private Position position;

    //plateau where rover is navigating
    private Plateau plateau;

    public Rover(Plateau plateau, Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    //changes rover's facing to left from current direction
    private void turnLeft() {
        position = position.rotateLeft();
    }

    //changes rover's facing to right from current direction
    private void turnRight() {
        position = position.rotateRight();
    }
    //moves rover one step forward in direction that it's facing
    private void move() {
        //checks if rover's move is within plateau coordinates
        if(plateau.isValidCoordinates(position.moveForward())) {
            position = position.moveForward();
        }
    }

    //executes string of input commands
    public void execute(String inputs) {
        inputs.chars().mapToObj( c -> (char) c).forEach(this::execute);
    }

    //executes each input command
    private void execute(Character command) {
        switch (command) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move();
                break;
        }
    }

    //checks if command is valid or not
    public Boolean validateCommand(String inputs) {
        if(Pattern.matches("[RLM]+$", inputs)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
