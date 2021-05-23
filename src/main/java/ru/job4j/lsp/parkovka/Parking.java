package ru.job4j.lsp.parkovka;

import java.util.List;

public interface Parking {

    void parking();

    void removeFromParking();

    List<Vehicle> getVehicles();
}
