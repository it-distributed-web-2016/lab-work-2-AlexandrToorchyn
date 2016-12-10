package com.turchyn.database;

public class SensorDb {
    public SensorDb(Integer id,
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
        this.temperature_sensor = temperature_sensor;
        this.humidity_sensor = humidity_sensor;
        this.gps = gps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
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

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    Integer id;
    Integer temperature;
    Integer humidity;
    String season;
    String temperature_sensor;
    String humidity_sensor;
    String gps;

}