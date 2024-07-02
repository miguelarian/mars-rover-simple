package com.miguelvela;

public class MarsRover
{
    private static final String INITIAL_POSITION = "0:0";

    private char direction = 'N';


    public String Execute(String command) {

        for (char action : command.toCharArray()) {

            if (action == 'R') {
                this.direction = rotateRight(this.direction, action);
            }

            if (action == 'L') {
                return INITIAL_POSITION + ":W";
            }
        }

        return INITIAL_POSITION + ":" + this.direction;
    }

    private char rotateRight(char currentPosition, char direction) throws IllegalArgumentException {
        if (currentPosition == 'N' && direction == 'R') {
            return 'E';
        }
        else if(currentPosition == 'E' && direction == 'R') {
            return 'S';
        }
        else if(currentPosition == 'S' && direction == 'R') {
            return 'W';
        }
        else if(currentPosition == 'W' && direction == 'R') {
            return 'N';
        }
        else {
            throw new IllegalArgumentException("Invalid direction");
        }
    }
}
