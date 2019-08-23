package com.unicamp.teste.teste.service;

import com.unicamp.teste.teste.entity.Forecast;
import com.unicamp.teste.teste.integration.DarkskyClient;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {

    private final DarkskyClient darkskyClient;

    public ForecastService(DarkskyClient darkskyClient) {
        this.darkskyClient = darkskyClient;
    }

    public String getForecast() {
        Forecast forecast = new Forecast();
        try {
            forecast = darkskyClient.getForecast("41.39715", "2.160873");
            System.out.println(forecast);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
