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
        if (capacity >= vehicles.size() + vehicle.getSize()) {
            return vehicles.add(vehicle);
        }
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    @Override
    public boolean contains(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }
}
