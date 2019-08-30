package com.unicamp.teste.teste.service;

import com.unicamp.teste.teste.entity.HotelOfferDTO;
import com.unicamp.teste.teste.integration.AmadeusClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final AmadeusClient amadeusClient;

    public BookingService(AmadeusClient amadeusClient) {
        this.amadeusClient = amadeusClient;
    }

    public List<HotelOfferDTO> getHotelOffers(String latitude, String longitude, String checkInDate, String checkOutDate) {

        return amadeusClient.getHotelOffers(latitude, longitude, checkInDate, checkOutDate);
    }
}
