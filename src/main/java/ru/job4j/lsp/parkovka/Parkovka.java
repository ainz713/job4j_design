package ru.job4j.lsp.parkovka;

import java.util.ArrayList;
import java.util.List;

public class Parkovka implements Parking {

    private List<Vehicle> vehicles;
    private AutoParking autoParking;
    private TruckParking truckParking;
    private int acapacity;
    private int tcapacity;

    public Parkovka(AutoParking autoParking, int acapacity,
                    TruckParking truckParking, int tcapacity) {
        this.autoParking = autoParking;
        this.acapacity = acapacity;
        this.truckParking = truckParking;
        this.tcapacity = tcapacity;
    }

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
