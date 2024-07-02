package com.miguelvela;

public class MarsRover
{
    private static final String INITIAL_POSITION = "0:0";

    private char direction = 'N';


    public String Execute(String command) {

        for (char action : command.toCharArray()) {

            if (action == 'R') {
                this.direction = rotateRight(this.direction);
            }

            if (action == 'L') {
                this.direction = rotateLeft(this.direction);
            }
        }

        return INITIAL_POSITION + ":" + this.direction;
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
}
