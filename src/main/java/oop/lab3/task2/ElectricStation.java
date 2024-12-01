package oop.lab3.task2;

public class ElectricStation implements  IRefuelable {
    private static int electricCars = 0;
    @Override
    public void refuel(String CarID) {
        System.out.println("Refueling electric car " + CarID + ".");
        electricCars++;
    }

    public static int getElectricCars() {
        return electricCars;
    }
}
