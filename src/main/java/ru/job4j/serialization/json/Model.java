package ru.job4j.serialization.json;

public class Model {
    private final int number;

    public Model(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Model{"
                + "number=" + number
                + '}';
    }

    public int getNumber() {
        return number;
    }
}
