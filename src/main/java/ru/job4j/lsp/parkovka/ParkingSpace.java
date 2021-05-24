package ru.job4j.lsp.parkovka;

import java.util.List;

public interface ParkingSpace {

    boolean add(Vehicle vehicle);

    boolean remove(Vehicle vehicle);

    boolean contains(Vehicle vehicle);

    List<Vehicle> findAll();
}
