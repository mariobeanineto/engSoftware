package com.unicamp.teste.teste.controller;

import com.unicamp.teste.teste.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping(path = "/forecast")
    public ResponseEntity<String> getForecast() {
        return ResponseEntity.ok(forecastService.getForecast());
    }
}
