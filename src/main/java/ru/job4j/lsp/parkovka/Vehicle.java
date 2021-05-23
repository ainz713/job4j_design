package ru.job4j.lsp.parkovka;

public abstract class Vehicle {

    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    abstract int getSize();
}
