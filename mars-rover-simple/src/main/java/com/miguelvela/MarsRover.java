package com.miguelvela;

import static com.miguelvela.Direction.*;

public class MarsRover
{
    private int XCoordinate;
    private int YCoordinate;
    private Direction direction;

    public int getXCoordinate() {
        return XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public MarsRover() {
        this.XCoordinate = 0;
        this.YCoordinate = 0;
        this.direction = Direction.North();
    }

    public MarsRover(int XCoordinate, int YCoordinate, Direction direction) {
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.direction = direction;
    }

    public String Execute(String command) {

        for (char inputAction : command.toCharArray()) {
            Action action = Action.fromValue(inputAction);
            switch (action) {
                case ROTATE_RIGHT -> rotateRight();
                case ROTATE_LEFT -> rotateLeft();
                case MOVE -> move();
                default -> throw new IllegalArgumentException("Invalid action");
            }
        }
        return this.toString();
    }

    private void move() {
        switch (this.direction.getValue()) {
            case NORTH -> this.YCoordinate++;
            case EAST -> this.XCoordinate++;
            case SOUTH -> this.YCoordinate--;
            case WEST -> this.XCoordinate--;
        }
    }

    private void rotateLeft() {
        switch (this.direction.getValue()) {
            case NORTH -> this.direction = West();
            case WEST -> this.direction = South();
            case SOUTH -> this.direction = East();
            case EAST -> this.direction = North();
            default -> throw new IllegalArgumentException("Invalid rotation");
        }
    }

    private void rotateRight() {
        switch (this.direction.getValue()) {
            case NORTH -> this.direction = East();
            case WEST -> this.direction = North();
            case SOUTH -> this.direction = West();
            case EAST -> this.direction = South();
            default -> throw new IllegalArgumentException("Invalid rotation");
        }
    }

    @Override
    public String toString() {
        return this.XCoordinate + ":" + this.YCoordinate + ":" + this.direction;
    }
}
