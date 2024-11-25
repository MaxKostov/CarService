package oop.lab3.task2;

public class GasStation implements IRefuelable{
    private static int gasCars = 0;
    @Override
    public void refuel(String CarID) {
        System.out.println("Refueling gas car " + CarID + ".");
        gasCars++;
    }

    public static int getGasCars() {
        return gasCars;
    }
}
