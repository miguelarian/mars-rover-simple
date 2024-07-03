package com.miguelvela;

enum Action {
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