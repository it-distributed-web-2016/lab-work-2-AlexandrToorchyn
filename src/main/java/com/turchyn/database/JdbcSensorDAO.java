package com.turchyn.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


public class JdbcSensorDAO implements SensorDAO
{
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(SensorDb sensorDb){

        String sql = "INSERT INTO CUSTOMER " +
                "(ID, TEMPERATURE, HUMIDITY, TEMPERATURE_SENSOR, HUMIDITY_SENSOR, GPS, SEASON) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sensorDb.getId());
            ps.setInt(2, sensorDb.getTemperature());
            ps.setInt(3, sensorDb.getHumidity());
            ps.setString(4, sensorDb.getTemperature_sensor());
            ps.setString(5, sensorDb.getHumidity_sensor());
            ps.setString(6, sensorDb.getGps());
            ps.setString(7, sensorDb.getSeason());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public SensorDb findBySensorId(int id){

        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            SensorDb sensorDb = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sensorDb = new SensorDb(
                        rs.getInt("ID"),
                        rs.getInt("TEMPERATURE"),
                        rs.getInt("HUMIDITY"),
                        rs.getString("TEMPERATURE_SENSOR"),
                        rs.getString("HUMIDITY_SENSOR"),
                        rs.getString("GPS"),
                        rs.getString("SEASON")

                );
            }
            rs.close();
            ps.close();
            return sensorDb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}