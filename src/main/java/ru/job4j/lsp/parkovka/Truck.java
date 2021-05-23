package ru.job4j.lsp.parkovka;

public class Truck extends Vehicle {

    private final int size;

    public Truck(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
