package com.unicamp.teste.teste.controller;

import com.unicamp.teste.teste.entity.HotelOfferDTO;
import com.unicamp.teste.teste.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(path = "/booking")
    public ResponseEntity<List<HotelOfferDTO>> getHotelOffers(@RequestParam String latitude, @RequestParam String longitude, @RequestParam String checkInDate, @RequestParam String checkOutDate) {
        return ResponseEntity.ok(bookingService.getHotelOffers(latitude, longitude, checkInDate, checkOutDate));
    }
}
