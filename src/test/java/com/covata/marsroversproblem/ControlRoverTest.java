package com.covata.marsroversproblem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ControlRoverTest {
    File inputFile;

    @Before
    public void setUp() {
        inputFile = new File("input.txt");
    }

    @After
    public void clearSetUp() {
        inputFile = null;
    }

    @Test
    public void shouldGetResults() throws Exception{
        ControlRover controlRover = new ControlRover(inputFile);
        String expectedOutput = "1 3 N\n5 1 E";
        assertEquals(controlRover.getResults(),expectedOutput);
    }
}
