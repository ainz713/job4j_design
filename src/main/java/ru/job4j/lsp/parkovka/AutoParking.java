package ru.job4j.lsp.parkovka;

import java.util.List;

public class AutoParking implements Parking {

    private ParkingSpace parkingSpace;
    private int capacity;
    private int count;

    public AutoParking(ParkingSpace parkingSpace, int capacity) {
        this.parkingSpace = parkingSpace;
        this.capacity = capacity;
    }

    @Override
    public void parking() {

    }

    @Override
    public void removeFromParking() {

    }

    @Override
    public List<Vehicle> getVehicles() {
        return parkingSpace.findAll();
    }
}
