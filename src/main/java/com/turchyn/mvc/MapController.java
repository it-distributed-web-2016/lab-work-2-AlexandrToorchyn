package com.turchyn.mvc;

import com.turchyn.database.SensorDAO;
import com.turchyn.database.SensorDb;
import com.turchyn.sensors.Sensors;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MapController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        Sensors sensorsList = new Sensors(20, 1000);
        ArrayList<SensorModel> sensors = sensorsList.getData();
        model.addAttribute("sensors", sensors);
        return "map";
    }

    public void updateDb(ArrayList<SensorModel> data) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");
        SensorDAO sensorDAO = (SensorDAO) context.getBean("sensorDAO");

        for(int i=0; i < data.size()-1; i++){
            Integer id = data.get(i).getId();
            Integer temperature = data.get(i).getTemperature();
            Integer humidity = data.get(i).getHumidity();
            String season = data.get(i).getSeason();
            String temperature_sensor = data.get(i).getTemperature_sensor();
            String humidity_sensor = data.get(i).getHumidity_sensor();
            String gps = data.get(i).getGps();

            SensorDb sensor = new SensorDb(id,temperature,humidity,season,temperature_sensor,humidity_sensor,gps);
            sensorDAO.insert(sensor);
        }
    }
}
