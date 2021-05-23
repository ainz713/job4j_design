package ru.job4j.lsp.parkovka;

import java.util.ArrayList;
import java.util.List;

public class Space implements ParkingSpace {

    private final List<Vehicle> vehicles;

    public Space(List<Vehicle> vehicles) {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void remove(Vehicle vehicle) {
        vehicles.remove(vehicle);
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
