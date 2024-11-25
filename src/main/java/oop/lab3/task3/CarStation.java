package oop.lab3.task3;

import oop.lab3.Car;
import oop.lab3.task1.Queue;
import oop.lab3.task2.IDineable;
import oop.lab3.task2.IRefuelable;

public class CarStation {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private Queue<Car> cars = new Queue<>();

    public CarStation(IDineable diningService, IRefuelable refuelingService) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
    }

    public void serveCars() {
        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            refuelingService.refuel(car.getId());
            if (car.isDining()) diningService.serveDinner(car.getId());
        }
    }

    public void addCar(Car car) {
        cars.enqueue(car);
    }
}
