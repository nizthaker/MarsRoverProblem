package com.covata.marsroversproblem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoverTest {
    Rover rover;

    @Before
    public void setUp() {
        Plateau plateau = new Plateau(5,5);
        rover = new Rover(plateau, new Position(1 ,2 ,Facing.NORTH));
    }

    @Test
    public void shouldTurnLeft() {
        rover.execute("L");
        assertEquals(rover.getPosition(), new Position(1, 2, Facing.WEST));
    }

    @Test
    public void shouldTurnRight() {
        rover.execute("R");
        assertEquals(rover.getPosition(), new Position(1, 2, Facing.EAST));
    }

    @Test
    public void shouldMove() {
        rover.execute("M");
        assertEquals(rover.getPosition(), new Position(1, 3, Facing.NORTH));
    }

    @Test
    public void shouldExecute() {
        rover.execute("LMRM");
        assertEquals(rover.getPosition(), new Position(0, 3, Facing.NORTH));
    }

    @Test
    public void shouldValidateCommand() {
        String inputs = "LMRM";
        assertTrue(rover.validateCommand(inputs));

        inputs = "ALMRM";
        assertFalse(rover.validateCommand(inputs));
    }

}
