package com.miguelvela;

public class MarsRover
{
    private final int INITIAL_X_COORDINATE = 0;
    private final int INITIAL_Y_COORDINATE = 0;
    private final int INITIAL_DIRECTION = 'N';

    private final char NORTH = 'N';
    private final char SOUTH = 'S';
    private final char EAST = 'E';
    private final char WEST = 'W';

    private enum Action {
        ROTATE_RIGHT('R'),
        ROTATE_LEFT('L'),
        MOVE('M');

        private char value;

        Action(char action) {
            this.value = action;
        }

        public static Action fromValue(char value) {
            for (Action action : Action.values()) {
                if (action.value == value) {
                    return action;
                }
            }
            throw new IllegalArgumentException("Invalid action");
        }
    }

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

        for (char inputAction : command.toCharArray()) {
            Action action = Action.fromValue(inputAction);
            switch (action) {
                case ROTATE_RIGHT -> this.direction = rotateRight(this.direction);
                case ROTATE_LEFT -> this.direction = rotateLeft(this.direction);
                case MOVE -> move();
                default -> throw new IllegalArgumentException("Invalid action");
            }
        }
        return this.toString();
    }

    private void move() {
        if (this.direction == NORTH) {
            this.YCoordinate++;
        }

        if (this.direction == EAST) {
            this.XCoordinate++;
        }

        if (this.direction == SOUTH) {
            this.YCoordinate--;
        }

        if (this.direction == WEST) {
            this.XCoordinate--;
        }
    }

    private char rotateLeft(char currentPosition) {
        if (currentPosition == NORTH) {
            return WEST;
        }
        else if(currentPosition == WEST) {
            return SOUTH;
        }
        else if(currentPosition == SOUTH) {
            return EAST;
        }
        else if(currentPosition == EAST) {
            return NORTH;
        }
        else {
            throw new IllegalArgumentException("Invalid rotation");
        }
    }

    private char rotateRight(char currentPosition) throws IllegalArgumentException {
        if (currentPosition == NORTH) {
            return EAST;
        }
        else if(currentPosition == EAST) {
            return SOUTH;
        }
        else if(currentPosition == SOUTH) {
            return WEST;
        }
        else if(currentPosition == WEST) {
            return NORTH;
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
