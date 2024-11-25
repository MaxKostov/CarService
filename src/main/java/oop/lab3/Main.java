package oop.lab3;

import oop.lab3.task1.Queue;
import oop.lab3.task4.Semaphore;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Queue<Car> generalQueue = new Queue<>();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CarReader(1, generalQueue, timer), 0, 3000);

        Semaphore sp = new Semaphore();

        Thread semaphoreThread = new Thread(() -> {
            while (true) {
                synchronized (generalQueue) {
                    if (!generalQueue.isEmpty()) {
                        Car car = generalQueue.dequeue();
                        sp.navigateCars(car); // Распределяем машину
                        System.out.println("Машина обработана: " + car);
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Поток семафора завершён.");
                    break;
                }
            }
        });

        semaphoreThread.start();
    }
}