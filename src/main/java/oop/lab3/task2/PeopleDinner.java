package oop.lab3.task2;

public class PeopleDinner implements IDineable{
    private static int people = 0;
    @Override
    public void serveDinner(String CarID) {
        System.out.println("Dinner for people from " + CarID + ".");
        people++;
    }

    public static int getPeople() {
        return people;
    }
}
