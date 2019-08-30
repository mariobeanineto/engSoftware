package com.unicamp.teste.teste.controller;

import com.unicamp.teste.teste.entity.ForecastDTO;
import com.unicamp.teste.teste.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping(path = "/forecast")
    public ResponseEntity<List<ForecastDTO>> getForecast(@RequestParam String latitude, @RequestParam String longitude, @RequestParam String dateIn, @RequestParam String dateOut) {
        return ResponseEntity.ok(forecastService.getForecast(latitude, longitude, dateIn, dateOut));
    }
}
