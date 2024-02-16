package com.example.demospringdispatcherservleterror.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {

    @GetMapping
    ResponseEntity<HelloWorldResponse> getMessage() {
        return ResponseEntity.ok(new HelloWorldResponse("Hello world"));
    }

    private record HelloWorldResponse(String message) {}

}
