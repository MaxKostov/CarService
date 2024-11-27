package oop.lab3.task3;

import oop.lab3.Car;
import oop.lab3.task1.Queue;
import oop.lab3.task2.IDineable;
import oop.lab3.task2.IRefuelable;

public class CarStation implements Runnable {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private Queue<Car> cars = new Queue<>();
    private Thread thread;
    private int stationId;
    private final Object queueLock = new Object();

    public CarStation(IDineable diningService, IRefuelable refuelingService, int stationId) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.stationId = stationId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Car car;
                synchronized (queueLock) {
                    if (cars.isEmpty()) {
                        updateTerminal("Thread terminating...");
                        break;
                    }

                    car = cars.dequeue();
                }

                for (int i = 0; i < 20; i++) {
                    updateTerminal("[" + "#".repeat(i) + " ".repeat(20 - i) + "] " + "Processing: Car" + car.getId() + " | Cars in queue: " + cars.size());
                    Thread.sleep(car.getConsumption() * 70);
                }

                System.out.println("-----------------------------");
                System.out.println("Car Station " + stationId + ":");
                refuelingService.refuel(car.getId());
                if (car.isDining()) diningService.serveDinner(car.getId());
                System.out.println("-----------------------------");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            updateTerminal("Thread interrupted");
        }
    }

    public void addCar(Car car) {
        synchronized (queueLock) {
            cars.enqueue(car);
            if (thread == null || !thread.isAlive()) {
                startThread();
            }
            queueLock.notify();
        }
    }

    private void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    public int getNumberOfCars() {
        synchronized (queueLock) {
            return cars.size();
        }
    }

    private void updateTerminal(String status) {
        System.out.printf("\033[%d;0HCarStation%d: %s\033[K\n", stationId + 1, stationId, status);
        System.out.flush();
    }
}


