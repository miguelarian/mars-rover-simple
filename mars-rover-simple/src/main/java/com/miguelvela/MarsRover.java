package com.miguelvela;

import static com.miguelvela.Direction.*;
import static com.miguelvela.Position.move;

public class MarsRover
{
    private Position position;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public MarsRover() {
        this.position = Position.StartPosition();
        this.direction = Direction.North();
    }

    public MarsRover(int XCoordinate, int YCoordinate, Direction direction) {
        this.position = Position.CustomPosition(XCoordinate, YCoordinate);
        this.direction = direction;
    }

    public String Execute(String command) {

        for (char inputAction : command.toCharArray()) {
            Action action = Action.fromValue(inputAction);
            switch (action) {
                case ROTATE_RIGHT -> this.direction = rotateRight(this.direction);
                case ROTATE_LEFT -> this.direction = rotateLeft(this.direction);
                case MOVE -> this.position = move(this.position, this.direction);
                default -> throw new IllegalArgumentException("Invalid action");
            }
        }
        return this.toString();
    }

    public int getXCoordinate() {
        return this.position.getX();
    }

    public int getYCoordinate() {
        return this.position.getY();
    }

    @Override
    public String toString() {
        return this.position + ":" + this.direction;
    }
}
