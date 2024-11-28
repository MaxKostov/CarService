package oop.lab3.task3;

import oop.lab3.Car;
import oop.lab3.task2.ElectricStation;
import oop.lab3.task2.GasStation;
import oop.lab3.task2.PeopleDinner;
import oop.lab3.task2.RobotDinner;
import org.junit.jupiter.api.Test;

public class CarStationTest {
    CarStation carStation1 = new CarStation(new PeopleDinner(), new GasStation());
    CarStation carStation2 = new CarStation(new RobotDinner(), new ElectricStation());

    Car car1 = new Car("1", "GAS", "PEOPLE", true, 12);
    Car car2 = new Car("2", "ELECTRIC", "ROBOTS", true, 11);
    Car car3 = new Car("3", "GAS", "PEOPLE", false, 13);
    Car car4 = new Car("4", "ELECTRIC", "ROBOTS", false, 10);

    @Test
    public void testService() {
        carStation1.addCar(car1);
        carStation1.addCar(car3);
        carStation1.serveCars();

        carStation2.addCar(car2);
        carStation2.addCar(car4);
        carStation2.serveCars();
    }
}
