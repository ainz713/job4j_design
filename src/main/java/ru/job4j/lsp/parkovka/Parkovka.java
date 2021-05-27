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
    }

    public Parkovka() {
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
