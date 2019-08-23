package com.unicamp.teste.teste.integration;

import com.unicamp.teste.teste.entity.Forecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${integration.client.darksky.uri}",  name="forecast")
public interface DarkskyClient {

    @GetMapping("${integration.client.darksky.uri.endpoint.forecast}")
    Forecast getForecast(@PathVariable("lat") String lat, @PathVariable("lon") String lon);

}
