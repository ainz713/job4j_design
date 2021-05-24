package ru.job4j.lsp.parkovka;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    Space parkingSpace;
    AutoParking autoParking;
    TruckParking truckParking;

    @Before
    public void init() {
        parkingSpace = new Space();
        autoParking = new AutoParking(parkingSpace, 10);
        truckParking = new TruckParking(parkingSpace, 4);
    }

    @Ignore
    @Test
    public void whenCarParkingAndLeaving() {
        Auto auto1 = new Auto("Car1");
        Auto auto2 = new Auto("Car2");
        assertTrue(autoParking.parking(auto1));
        assertTrue(parkingSpace.contains(auto1));
        assertTrue(autoParking.parking(auto2));
        assertTrue(parkingSpace.contains(auto2));
        assertThat(autoParking.getVehicles().size(), is(2));
        autoParking.removeFromParking(auto2);
        assertFalse(parkingSpace.contains(auto2));
        assertThat(autoParking.getVehicles().size(), is(1));
    }

    @Ignore
    @Test
    public void whenCarPlaceIsFull() {
        autoParking = new AutoParking(parkingSpace, 1);
        Auto auto1 = new Auto("Car1");
        assertTrue(autoParking.parking(auto1));
        Auto auto2 = new Auto("Car2");
        assertFalse(autoParking.parking(auto2));
    }

    @Ignore
    @Test
    public void whenTruckParkingFullAndLeaving() {
        Truck truck1 = new Truck("Truck1", 2);
        Truck truck2 = new Truck("Truck2", 2);
        assertTrue(truckParking.parking(truck1));
        assertTrue(parkingSpace.contains(truck1));
        assertTrue(truckParking.parking(truck2));
        assertTrue(parkingSpace.contains(truck2));
        assertThat(truckParking.getVehicles().size(), is(4));
        Truck truck3 = new Truck("Truck3", 2);
        assertFalse(truckParking.parking(truck3));
        truckParking.removeFromParking(truck1);
        assertFalse(parkingSpace.contains(truck1));
        assertTrue(truckParking.parking(truck3));
    }

    @Ignore
    @Test
    public void whenTruckParkingCarPlace() {
        Truck truck = new Truck("Truck", 2);
        assertTrue(autoParking.parking(truck));
        assertTrue(parkingSpace.contains(truck));
    }

    @Ignore
    @Test
    public void whenAutoNotParkingTruckPlace() {
        Auto auto1 = new Auto("Car1");
        assertFalse(truckParking.parking(auto1));
    }
}