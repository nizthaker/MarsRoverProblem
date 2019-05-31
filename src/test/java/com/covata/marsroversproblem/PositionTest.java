package com.covata.marsroversproblem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {
 private Position position;

    @Before
    public void setUp() {
        position = new Position(1 ,2 ,Direction.getDirection("N"));
    }

    @Test
    public void shouldRotateLeft() {
        assertEquals(position.rotateLeft(), new Position(1, 2, Direction.getDirection("W")));
    }

    @Test
    public void shouldRotateRight() {
        assertEquals(position.rotateRight(), new Position(1, 2, Direction.getDirection("E")));
    }

    @Test
    public void shouldMoveForward() {
        assertEquals(position.moveForward(), new Position(1, 3, Direction.getDirection("N")));
        position = new Position(1, 2, Direction.getDirection("E"));
        assertEquals(position.moveForward(), new Position(2, 2, Direction.getDirection("E")));
        position = new Position(1, 2,Direction.getDirection("W"));
        assertEquals(position.moveForward(), new Position(0, 2, Direction.getDirection("W")));
        position = new Position(1, 2,Direction.getDirection("S"));
        assertEquals(position.moveForward(), new Position(1, 1, Direction.getDirection("S")));
    }

    @Test
    public void shouldValidatePosition() {
        assertTrue(position.isValidPosition(5, 5));
        assertFalse(position.isValidPosition(1, 1));
    }

}
