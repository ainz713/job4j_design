package ru.job4j.lsp.parkovka;

import java.util.ArrayList;
import java.util.List;

public class Parkovka implements Parking {

    private final List<Vehicle> vehicles;

    public Parkovka() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public boolean parking(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean removeFromParking(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return null;
    }
}
