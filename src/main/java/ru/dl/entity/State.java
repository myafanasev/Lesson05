package ru.dl.entity;

public enum State {
    CLOSE ("0"),
    OPEN ("1"),
    RESERVE ("2"),
    DELETE("3");
    String numState;

    State(String numState) {
        this.numState = numState;
    }

    public String getNumState() {
        return numState;
    }
}
