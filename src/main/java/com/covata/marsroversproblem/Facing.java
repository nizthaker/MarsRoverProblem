package com.covata.marsroversproblem;

//Enum for rover directions
//Value can be any of N, E, W, S
//left() changes rover facing to left
//right() changes rover facing to right

public enum Facing {
    NORTH("N") {
        @Override
        public Facing left(){
            return WEST;
        }

        @Override
        public Facing right(){
            return EAST;
        }
    },

    EAST("E") {
        @Override
        public Facing left(){
            return NORTH;
        }

        @Override
        public Facing right(){
            return SOUTH;
        }
    },

    WEST("W") {
        @Override
        public Facing left(){
            return SOUTH;
        }

        @Override
        public Facing right(){
            return NORTH;
        }
    },

    SOUTH("S") {
        @Override
        public Facing left(){
            return EAST;
        }

        @Override
        public Facing right(){
            return WEST;
        }
    };

    private String facing;

    Facing(String facing) {
        this.facing = facing;
    }

    public abstract Facing left();

    public abstract Facing right();

    public static Facing getFacing(String facing) {
        switch (facing) {
            case "N":
                return NORTH;
            case "E":
                return EAST;
            case "W":
                return WEST;
            case "S":
                return SOUTH;
            default:
                throw new RuntimeException("Invalid Facing...");
        }
    }

    @Override
    public String toString() {
        return facing;
    }
}
