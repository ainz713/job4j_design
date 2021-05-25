package ru.job4j.lsp.parkovka;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    private Parkovka parkovka;
    private AutoParking autoParking;
    private TruckParking truckParking;

    @Before
    public void init() {
        parkovka = new Parkovka();
        autoParking = new AutoParking(parkovka, 10);
        truckParking = new TruckParking(parkovka, 4);
    }

    @Ignore
    @Test
    public void whenCarParkingAndLeaving() {
        Auto auto1 = new Auto("Car1");
        Auto auto2 = new Auto("Car2");
        assertTrue(parkovka.parking(auto1));
        assertTrue(autoParking.contains(auto1));
        assertTrue(parkovka.parking(auto2));
        assertTrue(autoParking.contains(auto2));
        assertThat(parkovka.getVehicles().size(), is(2));
        parkovka.removeFromParking(auto2);
        assertFalse(autoParking.contains(auto2));
        assertThat(parkovka.getVehicles().size(), is(1));
    }

    @Ignore
    @Test
    public void whenCarPlaceIsFull() {
        autoParking = new AutoParking(parkovka, 1);
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
        assertTrue(truckParking.contains(truck1));
        assertTrue(parkovka.parking(truck2));
        assertTrue(truckParking.contains(truck2));
        assertThat(parkovka.getVehicles().size(), is(4));
        Truck truck3 = new Truck("Truck3", 2);
        assertFalse(parkovka.parking(truck3));
        parkovka.removeFromParking(truck1);
        assertFalse(truckParking.contains(truck1));
        assertTrue(parkovka.parking(truck3));
    }

    @Ignore
    @Test
    public void whenTruckParkingCarPlace() {
        Truck truck = new Truck("Truck", 2);
        assertTrue(parkovka.parking(truck));
        assertTrue(autoParking.contains(truck));
    }

    @Ignore
    @Test
    public void whenAutoNotParkingTruckPlace() {
        Auto auto1 = new Auto("Car1");
        assertTrue(parkovka.parking(auto1));
        assertFalse(truckParking.contains(auto1));
    }
}