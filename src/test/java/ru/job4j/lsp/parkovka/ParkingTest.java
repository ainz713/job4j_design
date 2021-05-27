package ru.job4j.lsp.parkovka;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    private Parkovka parkovka;

    @Before
    public void init() {
        parkovka = new Parkovka(10, 4);
    }

    @Ignore
    @Test
    public void whenCarParkingAndLeaving() {
        Auto auto1 = new Auto("Car1");
        Auto auto2 = new Auto("Car2");
        assertTrue(parkovka.parking(auto1));
        assertTrue(parkovka.getAutoParking().contains(auto1));
        assertTrue(parkovka.parking(auto2));
        assertTrue(parkovka.getAutoParking().contains(auto2));
        assertThat(parkovka.getVehicles().size(), is(2));
        parkovka.removeFromParking(auto2);
        assertFalse(parkovka.getAutoParking().contains(auto2));
        assertThat(parkovka.getVehicles().size(), is(1));
    }

    @Ignore
    @Test
    public void whenCarPlaceIsFull() {
        parkovka = new Parkovka(1, 4);
        Auto auto1 = new Auto("Car1");
        assertTrue(parkovka.parking(auto1));
        Auto auto2 = new Auto("Car2");
        assertFalse(parkovka.parking(auto2));
    }

    @Ignore
    @Test
    public void whenTruckParkingFullAndLeaving() {
        Truck truck1 = new Truck("Truck1", 2);
        Truck truck2 = new Truck("Truck2", 2);
        assertTrue(parkovka.parking(truck1));
        assertTrue(parkovka.getTruckParking().contains(truck1));
        assertTrue(parkovka.parking(truck2));
        assertTrue(parkovka.getTruckParking().contains(truck2));
        assertThat(parkovka.getVehicles().size(), is(4));
        Truck truck3 = new Truck("Truck3", 2);
        assertFalse(parkovka.parking(truck3));
        parkovka.removeFromParking(truck1);
        assertFalse(parkovka.getTruckParking().contains(truck1));
        assertTrue(parkovka.parking(truck3));
    }

    @Ignore
    @Test
    public void whenTruckParkingCarPlace() {
        Truck truck = new Truck("Truck", 2);
        assertTrue(parkovka.parking(truck));
        assertTrue(parkovka.getAutoParking().contains(truck));
    }

    @Ignore
    @Test
    public void whenAutoNotParkingTruckPlace() {
        Auto auto1 = new Auto("Car1");
        assertTrue(parkovka.parking(auto1));
        assertFalse(parkovka.getTruckParking().contains(auto1));
    }
}