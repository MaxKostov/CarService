package oop.lab3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab3.task4.Semaphore;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CarReader extends TimerTask {
    private int index;
    private final Semaphore sp;
    private final Timer timer;

    public CarReader(int startIndex, Semaphore sp, Timer timer) {
        this.index = startIndex;
        this.sp = sp;
        this.timer = timer;
    }

    @Override
    public void run() {
        File file = new File("src/main/resources/queue/Car" + index + ".json");
        if (!file.exists()) {
            timer.cancel();
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode carData;
        try {
            carData = mapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + file.getName(), e);
        }

        Car car = new Car(
                carData.get("id").asText(),
                carData.get("type").asText(),
                carData.get("passengers").asText(),
                carData.get("isDining").asBoolean(),
                carData.get("consumption").asInt()
        );

        sp.navigateCars(car);
        index++;
    }
}
