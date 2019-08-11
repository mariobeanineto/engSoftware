package com.unicamp.teste.teste.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping(path = "/teste")
    public ResponseEntity<String> getAuthorizedUserName() {
        return ResponseEntity.ok("teste");
    }
}
