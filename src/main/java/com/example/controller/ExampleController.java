package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LDC
 */
@RestController
public class ExampleController {

    @Value("${config.example.value:Tom}")
    private String value;

    @GetMapping("/api/hello")
    public ResponseEntity<?> hello(@RequestParam(required = false, defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name);
    }

    @GetMapping("/api/value")
    public ResponseEntity<?> value() {
        return ResponseEntity.ok(value);
    }

}
