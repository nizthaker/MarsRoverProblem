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
        position = new Position(1 ,2 ,Facing.NORTH);
    }

    @Test
    public void shouldRotateLeft() {
        assertEquals(position.rotateLeft(), new Position(1, 2, Facing.WEST));
    }

    @Test
    public void shouldRotateRight() {
        assertEquals(position.rotateRight(), new Position(1, 2, Facing.EAST));
    }

    @Test
    public void shouldMoveForward() {
        assertEquals(position.moveForward(), new Position(1, 3, Facing.NORTH));
        position = new Position(1, 2, Facing.EAST);
        assertEquals(position.moveForward(), new Position(2, 2, Facing.EAST));
        position = new Position(1, 2, Facing.WEST);
        assertEquals(position.moveForward(), new Position(0, 2, Facing.WEST));
        position = new Position(1, 2, Facing.SOUTH);
        assertEquals(position.moveForward(), new Position(1, 1, Facing.SOUTH));
    }

    @Test
    public void shouldValidatePosition() {
        assertTrue(position.isValidPosition(5, 5));
        assertFalse(position.isValidPosition(1, 1));
    }

}
