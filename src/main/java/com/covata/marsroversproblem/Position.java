package com.covata.marsroversproblem;

import java.util.Objects;

//defines position of rover in the plateau
//(x, y) coordinates in plateau
//facing defines direction where rover is heading
public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    //changes facing to left from current direction
    public Position rotateLeft() {
        return new Position(x, y, direction.left());
    }

    //changes facing to right from current direction
    public Position rotateRight() {
        return new Position(x, y, direction.right());
    }

    //moves one step forward in direction of facing
    public Position moveForward() {
        switch (direction.toString()) {
            case "N":
                return new Position(x, y+1, direction);
            case "E":
                return new Position(x+1, y, direction);
            case "W":
                return new Position(x-1, y, direction);
            case "S":
                return new Position(x, y-1, direction);
            default:
                throw new RuntimeException("Invalid Direction");
        }
    }
    //checks if rovers position is within input (x, y) coordinates
    public boolean isValidPosition(int x, int y) {
        if(this.x <= x && this.y <= y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y &&
                direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
