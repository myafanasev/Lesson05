package ru.dl.model;

public enum EnumPlusMinus {
    HIGHT("+"),
    LOW("-");
    private String name;

    EnumPlusMinus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
