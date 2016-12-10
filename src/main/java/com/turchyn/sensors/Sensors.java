package com.turchyn.sensors;

import com.turchyn.mvc.SensorModel;

import java.util.*;
import java.util.concurrent.*;

public class Sensors {
    private int amount,
            maxSleepTime;
    private ExecutorService executor;
    private ArrayList<SensorModel> data = new ArrayList<>();
    private List<Future<HashMap<String,Object>>> sensorCallbackList = new ArrayList<>();

    public Sensors(int amount, int maxSleepTime) {
        this.amount = amount;
        this.maxSleepTime = maxSleepTime;
        initSensors();
    }

    private void initSensors() {
        executor = Executors.newFixedThreadPool(amount);
        for (int i = 0; i < amount; i++) {
            Callable<HashMap<String,Object>> callable = new Sensor(i + 1, maxSleepTime);
            Future<HashMap<String,Object>> future = executor.submit(callable);
            sensorCallbackList.add(future);
        }
    }

    public ArrayList<SensorModel> getData() {
        for (Future<HashMap<String,Object>> fut : sensorCallbackList) {
            try {
                HashMap<String,Object> sensor = fut.get();
                data.add(new SensorModel((Integer) sensor.get("id"),
                                         (Integer)sensor.get("temperature"),
                                         (Integer) sensor.get("humidity"),
                                         (String)sensor.get("season"),
                                         (String)sensor.get("temperature_sensor"),
                                         (String)sensor.get("humidity_sensor"),
                                         (String)sensor.get("gps")));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return data;
    }
}
