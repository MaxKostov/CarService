package oop.lab3;

import oop.lab3.task1.Queue;
import oop.lab3.task4.Semaphore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String command = "python3";
        String scriptPath = "script/generator.py";
        LinkedList<String> output = new LinkedList<>();

        Thread pythonThread = new Thread(() -> {
            try {
                Process process = new ProcessBuilder(command, scriptPath).start();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pythonThread.start();

        Timer timer = new Timer();
        Semaphore sp = new Semaphore();
        timer.scheduleAtFixedRate(new CarReader(1, sp, timer), 0, 3000);

        System.out.println(output.getLast());
    }
}
