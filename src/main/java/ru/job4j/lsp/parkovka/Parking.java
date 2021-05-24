package ru.job4j.lsp.parkovka;

import java.util.List;

public interface Parking {

    boolean parking(Vehicle vehicle);

    boolean removeFromParking(Vehicle vehicle);

    List<Vehicle> getVehicles();
}
