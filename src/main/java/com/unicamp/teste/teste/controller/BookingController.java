package com.unicamp.teste.teste.controller;

import com.unicamp.teste.teste.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(path = "/teste")
    public ResponseEntity<String> getAuthorizedUserName() {
        return ResponseEntity.ok(bookingService.teste());
    }
}
