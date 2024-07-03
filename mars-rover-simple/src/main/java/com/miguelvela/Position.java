package com.miguelvela;

import static com.miguelvela.Direction.*;

public class Position {
    private static final int MAX_NORTH_COORDINATE = 10;

    private int X;
    private int Y;

    public static Position StartPosition() {
        return new Position(0, 0);
    }

    public static Position CustomPosition(int xCoordinate, int yCoordinate) {
        return new Position(xCoordinate, yCoordinate);
    }

    private Position(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public static Position moveNorth(Position position) {
        if((position.Y + 1) == MAX_NORTH_COORDINATE) {
            return new Position(position.X, 0);
        }
        return new Position(position.X, position.Y + 1);
    }

    public static Position moveEast(Position position) {
        return new Position(position.X + 1, position.Y);
    }

    public static Position moveSouth(Position position) {
        return new Position(position.X, position.Y - 1);
    }

    public static Position moveWest(Position position) {
        return new Position(position.X - 1, position.Y);
    }

    public static Position move(Position position, Direction direction) {
        return switch (direction.getValue()) {
            case NORTH -> moveNorth(position);
            case EAST -> moveEast(position);
            case SOUTH -> moveSouth(position);
            case WEST -> moveWest(position);
            default -> throw new IllegalArgumentException("Invalid direction");
        };
    }

    @Override
    public String toString() {
        return this.X + ":" + this.Y;
    }
}
