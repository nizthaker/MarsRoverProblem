package com.covata.marsroversproblem;

import java.util.Objects;

//rectangular plateau on which rovers navigate
//(x, y) defines size for plateau
public class Plateau {
    private int x;
    private int y;


    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //checks if position is valid for plateau
    public boolean isValidCoordinates(Position position) {
        return position.isValidPosition(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plateau)) return false;
        Plateau plateau = (Plateau) o;
        return x == plateau.x &&
                y == plateau.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
