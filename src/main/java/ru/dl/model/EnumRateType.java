package ru.dl.model;

public enum EnumRateType {
    DIFFERENT ("0"),
    PROGRESS("1");
    private String name;

    EnumRateType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
