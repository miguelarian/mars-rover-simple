package com.miguelvela;

public class MarsRover
{
    private final int INITIAL_X_COORDINATE = 0;
    private final int INITIAL_Y_COORDINATE = 0;
    private final int INITIAL_DIRECTION = 'N';

    private int XCoordinate;
    private int YCoordinate;
    private char direction;

    public MarsRover() {
        this.XCoordinate = INITIAL_X_COORDINATE;
        this.YCoordinate = INITIAL_Y_COORDINATE;
        this.direction = INITIAL_DIRECTION;
    }

    public MarsRover(int XCoordinate, int YCoordinate, char direction) {
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.direction = direction;
    }

    public String Execute(String command) {

        for (char action : command.toCharArray()) {
            switch (action) {
                case 'R' -> this.direction = rotateRight(this.direction);
                case 'L' -> this.direction = rotateLeft(this.direction);
                case 'M' -> move();
                default -> throw new IllegalArgumentException("Invalid action");
            }
        }
        return this.toString();
    }

    private void move() {
        if (this.direction == 'N') {
            this.YCoordinate++;
        }

        if (this.direction == 'E') {
            this.XCoordinate++;
        }

        if (this.direction == 'S') {
            this.YCoordinate--;
        }

        if (this.direction == 'W') {
            this.XCoordinate--;
        }
    }

    private char rotateLeft(char currentPosition) {
        if (currentPosition == 'N') {
            return 'W';
        }
        else if(currentPosition == 'W') {
            return 'S';
        }
        else if(currentPosition == 'S') {
            return 'E';
        }
        else if(currentPosition == 'E') {
            return 'N';
        }
        else {
            throw new IllegalArgumentException("Invalid rotation");
        }
    }

    private char rotateRight(char currentPosition) throws IllegalArgumentException {
        if (currentPosition == 'N') {
            return 'E';
        }
        else if(currentPosition == 'E') {
            return 'S';
        }
        else if(currentPosition == 'S') {
            return 'W';
        }
        else if(currentPosition == 'W') {
            return 'N';
        }
        else {
            throw new IllegalArgumentException("Invalid rotation");
        }
    }

    @Override
    public String toString() {
        return this.XCoordinate + ":" + this.YCoordinate + ":" + this.direction;
    }
}
