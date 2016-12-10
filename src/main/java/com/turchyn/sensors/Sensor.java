package com.turchyn.sensors;


import java.lang.*;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

public class Sensor implements Callable<HashMap<String, Object>> {
    private int numberOfSensor,
            maxSleepTime;

    Sensor(int numberOfSensor, int maxSleep) {
        this.maxSleepTime = maxSleep;
        this.numberOfSensor = numberOfSensor;
    }

    @Override
    public HashMap<String, Object> call() throws Exception {
        HashMap<String, Object> sensor = new HashMap<>();
        Random rand = new Random();
        String season;
        int temperature;
        int sleep = rand.nextInt(maxSleepTime);
        int humidity = rand.nextInt(80) + 20;
        String humiditySensor = "В" + (rand.nextInt(899) + 100) + "ЕЕ";
        String temperatureSensor = "Т20І" + (rand.nextInt(899) + 100);
        String GPS = "48.931" + (rand.nextInt(899) + 100) + ", 24.697" + (rand.nextInt(899) + 100);
        if (rand.nextFloat() > 0.5) {
            season = "Тепала пора року";
            temperature = rand.nextInt(35) + 5;
        } else {
            season = "Холодна пора року";
            temperature = rand.nextInt(25) - 20;
        }
        Thread.sleep(sleep);
        sensor.put("id", numberOfSensor);
        sensor.put("temperature", temperature);
        sensor.put("humidity", humidity);
        sensor.put("season", season);
        sensor.put("humidity_sensor", humiditySensor);
        sensor.put("temperature_sensor", temperatureSensor);
        sensor.put("gps", GPS);
        return sensor;
    }
}
