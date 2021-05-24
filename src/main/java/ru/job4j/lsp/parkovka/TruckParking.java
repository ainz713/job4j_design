package ru.job4j.lsp.parkovka;

import java.util.List;

public class TruckParking implements Parking {

    private ParkingSpace parkingSpace;
    private int capacity;
    private int count;

    public TruckParking(ParkingSpace parkingSpace, int capacity) {
        this.parkingSpace = parkingSpace;
        this.capacity = capacity;
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
        return parkingSpace.findAll();
    }
}
