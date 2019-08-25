package com.unicamp.teste.teste.service;

import com.unicamp.teste.teste.entity.Data;
import com.unicamp.teste.teste.entity.Forecast;
import com.unicamp.teste.teste.integration.DarkskyClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class ForecastService {

    private final DarkskyClient darkskyClient;

    public ForecastService(DarkskyClient darkskyClient) {
        this.darkskyClient = darkskyClient;
    }

    public String getForecast(String latitude, String longitude, String day) {
        Forecast forecast;
        try {
            LocalDate daySelected = LocalDate.parse(day);

            Instant instant = daySelected.atStartOfDay(ZoneId.systemDefault()).toInstant();
            forecast = darkskyClient.getForecast(latitude, longitude, instant.getEpochSecond());
        } catch (Exception e) {
            throw new RuntimeException("Sorry, we had a problem. Please try again later");
        }
        String teste = "teste";
        for (Data x : forecast.getDaily().getData()) {
            teste = x.getSummary();
        }
        return teste;
    }

}
