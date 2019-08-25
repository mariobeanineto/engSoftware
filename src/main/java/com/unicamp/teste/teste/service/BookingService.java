package com.unicamp.teste.teste.service;

import com.unicamp.teste.teste.integration.AmadeusClient;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final AmadeusClient amadeusClient;

    public BookingService(AmadeusClient amadeusClient) {
        this.amadeusClient = amadeusClient;
    }

    public String teste() {

        return amadeusClient.getHotelOffers("52.5238", "13.3835", "2019-10-10", "2019-10-15");
    }
}
