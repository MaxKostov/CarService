package oop.lab3.task4;

import oop.lab3.Car;
import oop.lab3.task1.Queue;
import oop.lab3.task2.ElectricStation;
import oop.lab3.task2.GasStation;
import oop.lab3.task2.PeopleDinner;
import oop.lab3.task2.RobotDinner;
import oop.lab3.task3.CarStation;

public class Semaphore {
    private CarStation carStation1 = new CarStation(new PeopleDinner(), new GasStation());
    private CarStation carStation2 = new CarStation(new PeopleDinner(), new ElectricStation());
    private CarStation carStation3 = new CarStation(new RobotDinner(), new GasStation());
    private CarStation carStation4 = new CarStation(new RobotDinner(), new ElectricStation());
    private Queue<Car> genQueue = new Queue<>();

    public void add(Car car) {
        genQueue.enqueue(car);
    }

    public void navigateCars() {
        while (!genQueue.isEmpty()) {
            Car car = genQueue.dequeue();
            if(car.isDining()) {
                switch (car.getPassangers()) {
                    case "PEOPLE" -> {
                        switch (car.getType()) {
                            case "GAS" -> {
                                carStation1.addCar(car);
                            }
                            case "ELECTRIC" -> {
                                carStation2.addCar(car);
                            }
                        }
                    }
                    case "ROBOTS" -> {
                        switch (car.getType()) {
                            case "GAS" -> {
                                carStation3.addCar(car);
                            }
                            case "ELECTRIC" -> {
                                carStation4.addCar(car);
                            }
                        }
                    }
                }
            }
            else {
                switch (car.getType()) {
                    case "GAS" -> {
                        if (carStation1.getNumberOfCars() <= carStation3.getNumberOfCars()) {
                            carStation1.addCar(car);
                        } else {
                            carStation3.addCar(car);
                        }
                    }
                    case "ELECTRIC" -> {
                        if (carStation2.getNumberOfCars() <= carStation4.getNumberOfCars()) {
                            carStation2.addCar(car);
                        } else {
                            carStation4.addCar(car);
                        }
                    }
                }
            }
        }

    }
}
