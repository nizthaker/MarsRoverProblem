package com.covata.marsroversproblem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlateauTest {
    Plateau plateau;

    @Before
    public void setUp() {
         plateau = new Plateau(5,5);
    }

    @Test
    public void shouldValidateCoordinates() {
        Position position = new Position(1,2,Direction.getDirection("N"));
        assertTrue(plateau.isValidCoordinates(position));
        position = new Position(5,6,Direction.getDirection("N"));
        assertFalse(plateau.isValidCoordinates(position));
    }
}
