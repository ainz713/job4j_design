package ru.job4j.lsp.parkovka;

import java.util.ArrayList;
import java.util.List;

public class Parkovka implements Parking {

    private List<Vehicle> vehicles;
    private AutoParking autoParking;

    private TruckParking truckParking;
    private int acapacity;
    private int tcapacity;

    public Parkovka(int acapacity, int tcapacity) {
        this.autoParking = new AutoParking(acapacity);
        this.acapacity = acapacity;
        this.truckParking = new TruckParking(tcapacity);
        this.tcapacity = tcapacity;
        this.vehicles = new ArrayList<>();
    }

    public AutoParking getAutoParking() {
        return autoParking;
    }

    public TruckParking getTruckParking() {
        return truckParking;
    }

    @Override
    public boolean parking(Vehicle vehicle) {
        vehicles.add(vehicle);
        if (vehicle.getSize() > 1 && (tcapacity >= truckParking.findAll().size() + 1)) {
            return truckParking.add(vehicle);
        }
        return autoParking.add(vehicle);
    }

    @Override
    public boolean removeFromParking(Vehicle vehicle) {
        vehicles.remove(vehicle);
        if (vehicle.getSize() > 1) {
            return truckParking.remove(vehicle);
        }
        return autoParking.remove(vehicle);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
