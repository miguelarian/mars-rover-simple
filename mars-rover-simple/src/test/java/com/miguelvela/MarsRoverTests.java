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

    @Test
    public void Execute_FromInitialToLeft_ReturnsWest() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("L");
        assertEquals("0:0:W", result);
    }

    @Test
    public void Execute_FromInitialRotate180Left_ReturnsSouth() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("LL");
        assertEquals("0:0:S", result);
    }

    @Test
    public void Execute_FromInitialRotate270Left_ReturnsSouth() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("LLL");
        assertEquals("0:0:E", result);
    }

    @Test
    public void Execute_FromInitialRotate360Left_ReturnsInitialDirection() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("LLLL");
        assertEquals("0:0:N", result);
    }

    @Test
    public void Execute_FromInitialToRight_ReturnsEast() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("R");
        assertEquals("0:0:E", result);
    }

    @Test
    public void Execute_FromInitialRotate180Right_ReturnsSouth() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("RR");
        assertEquals("0:0:S", result);
    }

    @Test
    public void Execute_FromInitialRotate270Right_ReturnsWest() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("RRR");
        assertEquals("0:0:W", result);
    }

    @Test
    public void Execute_FromInitialRotate360Right_ReturnsInitialDirection() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("RRRR");
        assertEquals("0:0:N", result);
    }

    @Test
    public void Execute_MoveForwardNorth_ReturnsNorthPosition() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("M");
        assertEquals("0:1:N", result);
    }

    @Test
    public void Execute_MoveForwardEast_ReturnsNextEastPosition() {
        MarsRover rover = new MarsRover();
        String result = rover.Execute("RM");
        assertEquals("1:0:E", result);
    }

    @Test
    public void Execute_MoveForwardSouth_ReturnsNextSouthPosition() {
        MarsRover rover = new MarsRover(5,5, 'N');
        String result = rover.Execute("RRM");
        assertEquals("5:4:S", result);
    }

    @Test
    public void Execute_MoveForwardWest_ReturnsNextWestPosition() {
        MarsRover rover = new MarsRover(5,5, 'N');
        String result = rover.Execute("LM");
        assertEquals("4:5:W", result);
    }
}