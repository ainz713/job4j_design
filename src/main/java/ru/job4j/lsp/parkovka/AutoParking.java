package ru.job4j.lsp.parkovka;

import java.util.List;

public class AutoParking implements ParkingSpace {

    private Parkovka parkovka;
    private int capacity;
    private int count;

    public AutoParking(Parkovka parkovka, int capacity) {
        this.parkovka = parkovka;
        this.capacity = capacity;
    }


    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean contains(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Vehicle> findAll() {
        return null;
    }
}
