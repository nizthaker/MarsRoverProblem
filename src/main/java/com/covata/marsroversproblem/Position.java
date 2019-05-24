package com.covata.marsroversproblem;

import java.util.Objects;

//defines position of rover in the plateau
//(x, y) coordinates in plateau
//facing defines direction where rover is heading
public class Position {
    private int x;
    private int y;
    private Facing facing;

    public Position(int x, int y, Facing facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    //changes facing to left from current direction
    public Position rotateLeft() {
        return new Position(x, y, facing.left());
    }

    //changes facing to right from current direction
    public Position rotateRight() {
        return new Position(x, y, facing.right());
    }

    //moves one step forward in direction of facing
    public Position moveForward() {
        switch (facing.toString()) {
            case "N":
                return new Position(x, y+1, facing);
            case "E":
                return new Position(x+1, y, facing);
            case "W":
                return new Position(x-1, y, facing);
            case "S":
                return new Position(x, y-1, facing);
            default:
                throw new RuntimeException("Invalid Facing");
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
        return x + " " + y + " " + facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y &&
                facing == position.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }
}
