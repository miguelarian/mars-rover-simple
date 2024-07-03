package com.miguelvela;

public class MarsRover
{
    private final int INITIAL_X_COORDINATE = 0;
    private final int INITIAL_Y_COORDINATE = 0;
    private final int INITIAL_DIRECTION = 'N';

    public static final char NORTH = 'N';
    public static final char SOUTH = 'S';
    public static final char EAST = 'E';
    public static final char WEST = 'W';

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

    public int getXCoordinate() {
        return XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public char getDirection() {
        return direction;
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
                case ROTATE_RIGHT -> rotateRight(this.direction);
                case ROTATE_LEFT -> rotateLeft(this.direction);
                case MOVE -> move();
                default -> throw new IllegalArgumentException("Invalid action");
            }
        }
        return this.toString();
    }

    private void move() {
        switch (this.direction) {
            case NORTH -> this.YCoordinate++;
            case EAST -> this.XCoordinate++;
            case SOUTH -> this.YCoordinate--;
            case WEST -> this.XCoordinate--;
        }
    }

    private void rotateLeft(char currentDirection) {
        switch (currentDirection) {
            case NORTH -> this.direction = WEST;
            case WEST -> this.direction = SOUTH;
            case SOUTH -> this.direction = EAST;
            case EAST -> this.direction = NORTH;
            default -> throw new IllegalArgumentException("Invalid rotation");
        }
    }

    private void rotateRight(char currentDirection) {
        switch (currentDirection) {
            case NORTH -> this.direction = EAST;
            case WEST -> this.direction = NORTH;
            case SOUTH -> this.direction = WEST;
            case EAST -> this.direction = SOUTH;
            default -> throw new IllegalArgumentException("Invalid rotation");
        }
    }

    @Override
    public String toString() {
        return this.XCoordinate + ":" + this.YCoordinate + ":" + this.direction;
    }
}
