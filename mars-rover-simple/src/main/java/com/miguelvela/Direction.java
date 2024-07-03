package com.miguelvela;

import java.util.Objects;

public class Direction {
    public static final char NORTH = 'N';
    public static final char SOUTH = 'S';
    public static final char EAST = 'E';
    public static final char WEST = 'W';

    private char value;

    private Direction(char value) {
        this.value = value;
    }

    public static Direction North() {
        return new Direction(NORTH);
    }

    public static Direction South() {
        return new Direction(SOUTH);
    }

    public static Direction East() {
        return new Direction(EAST);
    }

    public static Direction West() {
        return new Direction(WEST);
    }

    public char getValue() {
        return value;
    }

    public static Direction rotateLeft(Direction direction) {
        return switch (direction.getValue()) {
            case NORTH -> West();
            case WEST -> South();
            case SOUTH -> East();
            case EAST -> North();
            default -> throw new IllegalArgumentException("Invalid rotation");
        };
    }

    public static Direction rotateRight(Direction direction) {
        return switch (direction.getValue()) {
            case NORTH -> East();
            case WEST -> North();
            case SOUTH ->West();
            case EAST -> South();
            default -> throw new IllegalArgumentException("Invalid rotation");
        };
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return value == direction.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
