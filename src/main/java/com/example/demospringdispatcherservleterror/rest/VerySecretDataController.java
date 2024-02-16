package com.example.demospringdispatcherservleterror.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/secure", produces = MediaType.APPLICATION_JSON_VALUE)
public class VerySecretDataController {

    @GetMapping
    ResponseEntity<SecretData> getData() {
        return ResponseEntity.ok(new SecretData("Top secret content"));
    }

    private record SecretData(String message) {}

}
