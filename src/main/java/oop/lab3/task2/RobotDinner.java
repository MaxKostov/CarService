package oop.lab3.task2;

public class RobotDinner implements IDineable {
    private static int robots = 0;
    @Override
    public void serveDinner(String CarID) {
        System.out.println("Dinner is serving for robots from " + CarID + ".");
        robots++;
    }

    public static int getRobots() {
        return robots;
    }
}
