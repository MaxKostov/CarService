package oop.lab3.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationTest {
    IRefuelable electricStation1 = new ElectricStation();
    IRefuelable electricStation2 = new ElectricStation();
    IRefuelable gasStation1 = new GasStation();
    IRefuelable gasStation2 = new GasStation();

    IDineable peopleDin1 = new PeopleDinner();
    IDineable peopleDin2 = new PeopleDinner();
    IDineable robotDin1 = new RobotDinner();
    IDineable robotDin2 = new RobotDinner();

    @Test
    public void refuelingTest() {
        electricStation1.refuel("1");
        electricStation2.refuel("2");
        gasStation1.refuel("3");
        gasStation2.refuel("4");

        assertEquals(2, ElectricStation.getElectricCars());
        assertEquals(2, GasStation.getGasCars());
    }

    @Test
    public void dinTest() {
        peopleDin1.serveDinner("1");
        peopleDin2.serveDinner("2");
        robotDin1.serveDinner("3");
        robotDin2.serveDinner("4");

        assertEquals(2, PeopleDinner.getPeople());
        assertEquals(2, RobotDinner.getRobots());
    }
}
