package com.unicamp.teste.teste.service;

import com.unicamp.teste.teste.entity.Forecast;
import com.unicamp.teste.teste.entity.ForecastDTO;
import com.unicamp.teste.teste.integration.DarkskyClient;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastService {

    private final DarkskyClient darkskyClient;

    public ForecastService(DarkskyClient darkskyClient) {
        this.darkskyClient = darkskyClient;
    }

    public List<ForecastDTO> getForecast(String latitude, String longitude, String dateIn, String dateOut) {
        List<ForecastDTO> forecastDTOList = new ArrayList<>();
        try {
            LocalDate initialDate = LocalDate.parse(dateIn);
            LocalDate finalDate = LocalDate.parse(dateOut);

            Duration duration = Duration.between(finalDate.atStartOfDay(), initialDate.atStartOfDay());
            long diff = Math.abs(duration.toDays());

            for (int i = 0; i <= diff; i++) {
                ForecastDTO forecastDTO = getDailyForecast(latitude, longitude, initialDate.plusDays(i));
                forecastDTO.setId(String.valueOf(i));
                forecastDTOList.add(forecastDTO);
            }


        } catch (Exception e) {
            throw new RuntimeException("Sorry, we had a problem. Please try again later");
        }
        return forecastDTOList;
    }

    private ForecastDTO getDailyForecast(String latitude, String longitude, LocalDate day) throws Exception {
        Instant instant = day.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Forecast forecast = darkskyClient.getForecast(latitude, longitude, instant.getEpochSecond());
        return getForecastDto(forecast, day);
    }

    private ForecastDTO getForecastDto(Forecast forecast, LocalDate day) {
        ForecastDTO forecastDTO = new ForecastDTO();
        forecastDTO.setDay(day.toString());
        forecastDTO.setIcon(forecast.getDaily().getData().get(0).getIcon());
        forecastDTO.setSummary(forecast.getDaily().getData().get(0).getSummary());
        forecastDTO.setMinTemp(String.valueOf(forecast.getDaily().getData().get(0).getTemperatureMin()));
        forecastDTO.setMaxTemp(String.valueOf(forecast.getDaily().getData().get(0).getApparentTemperatureHigh()));
        return forecastDTO;
    }
}
