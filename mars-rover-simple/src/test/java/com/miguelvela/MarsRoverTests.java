package com.miguelvela;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTests {

    @Test
    public void Execute_WithNoInstructions_ReturnsInitialPosition() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("");
        assertEquals("0:0:N", result);
    }

}