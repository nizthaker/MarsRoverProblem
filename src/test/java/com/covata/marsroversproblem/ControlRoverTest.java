package com.covata.marsroversproblem;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ControlRoverTest {
    File inputFile;

    @Test
    public void shouldGetResults() throws Exception{
        inputFile = new File("input.txt");
        ControlRover controlRover = new ControlRover(inputFile);
        String expectedOutput = "1 3 N\n5 1 E";
        assertEquals(controlRover.getResults(),expectedOutput);
    }

    @Test
    public void shouldThrowErrorWhenProvideWrongInputFileName() throws Exception{
        inputFile = new File("ienput.txt");
        ControlRover controlRover = new ControlRover(inputFile);
        String expectedOutput = "1 3 N\n5 1 E";
        try {
            assertEquals(controlRover.getResults(), expectedOutput);
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

}
