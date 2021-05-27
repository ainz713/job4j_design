package ru.job4j.lsp.parkovka;

import java.util.ArrayList;
import java.util.List;

public class AutoParking implements ParkingSpace {

    private final List<Vehicle> vehicles;
    private int capacity;

    public AutoParking(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
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
