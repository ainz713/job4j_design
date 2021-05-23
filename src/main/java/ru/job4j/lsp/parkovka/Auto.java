package ru.job4j.lsp.parkovka;

public class Auto extends Vehicle {

    public Auto(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        return 1;
    }
}
