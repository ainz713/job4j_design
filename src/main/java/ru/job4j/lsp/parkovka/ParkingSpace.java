package ru.job4j.lsp.parkovka;

import java.util.List;

public interface ParkingSpace {

    void add(Vehicle vehicle);

    void remove(Vehicle vehicle);

    boolean contains(Vehicle vehicle);

    List<Vehicle> findAll();
}
