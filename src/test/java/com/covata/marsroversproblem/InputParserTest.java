package com.covata.marsroversproblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputParserTest {

    @Test
    public void shouldGetPlateau() {
        String input = "5 5";
        assertEquals(InputParser.parsePlateau(input), new Plateau(5, 5));
    }

    @Test
    public void shouldGetNullIfInvalidPlateauInput() {
        String input = "5S";
        assertEquals(InputParser.parsePlateau(input), null);
    }

    @Test
    public void shouldGetPosition() {
        String input = "1 2 N";
        assertEquals(InputParser.parsePosition(input), new Position(1, 2, Facing.NORTH));
    }

    @Test
    public void shouldGetNullIfInvalidPositionInput() {
        String input = "12 A";
        assertEquals(InputParser.parsePosition(input), null);
    }

}
