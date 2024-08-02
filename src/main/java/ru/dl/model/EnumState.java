package ru.dl.model;

// состяния счета
public enum EnumState {
    CLOSE ("0"),
    OPEN ("1"),
    RESERVE ("2"),
    DELETE("3");
    String numState;

    EnumState(String numState) {
        this.numState = numState;
    }

    public String getNumState() {
        return numState;
    }
}
