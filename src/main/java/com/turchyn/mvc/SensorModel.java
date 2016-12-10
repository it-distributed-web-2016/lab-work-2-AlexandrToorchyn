package com.turchyn.mvc;

public class SensorModel {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private Integer temperature;
    private Integer humidity;
    private String season;
    private String temperature_sensor;
    private String humidity_sensor;
    private String gps;

    public SensorModel(Integer id,
                       Integer temperature,
                       Integer humidity,
                       String season,
                       String temperature_sensor,
                       String humidity_sensor,
                       String gps) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.season = season;
        this.humidity_sensor = humidity_sensor;
        this.temperature_sensor = temperature_sensor;
        this.gps = gps;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }


    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperaturem) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getTemperature_sensor() {
        return temperature_sensor;
    }

    public void setTemperature_sensor(String temperature_sensor) {
        this.temperature_sensor = temperature_sensor;
    }

    public String getHumidity_sensor() {
        return humidity_sensor;
    }

    public void setHumidity_sensor(String humidity_sensor) {
        this.humidity_sensor = humidity_sensor;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
