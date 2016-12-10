package com.turchyn.database;

public interface SensorDAO
{
    public void insert(SensorDb sensorDb);
    public SensorDb findBySensorId(int id);
}