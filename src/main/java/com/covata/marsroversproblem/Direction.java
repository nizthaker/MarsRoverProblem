package com.covata.marsroversproblem;

public enum  Direction {
    N(0), E(1), S(2), W(3);

    private final int dir;
    private static final Direction[] directionValues = Direction.values();

    Direction(int value) {
        dir = value;
    }

    public Direction left() {
        int prevDir = dir - 1;
        if (prevDir < 0) {
            prevDir = 3;
        }
        return directionValues[prevDir];
    }

    public Direction right() {
        return directionValues[(dir + 1) % 4];
    }

    public static Direction getDirection(String facing) {
        switch (facing) {
            case "N":
                return Direction.N;
            case "S":
                return Direction.S;
            case "E":
                return Direction.E;
            case "W":
                return Direction.W;
            default:
                throw new RuntimeException("Invalid Direction");
        }
    }
}
