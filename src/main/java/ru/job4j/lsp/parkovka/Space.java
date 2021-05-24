package ru.job4j.lsp.parkovka;

import java.util.ArrayList;
import java.util.List;

public class Space implements ParkingSpace {

    private final List<Vehicle> vehicles;

    public Space() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return vehicles.add(vehicle);
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
        return List.copyOf(vehicles);
    }
}
