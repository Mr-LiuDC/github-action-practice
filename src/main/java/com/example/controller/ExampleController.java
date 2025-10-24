package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LDC
 */
@RestController
public class ExampleController {

    @Value("${config.example.value:this-is-default-value}")
    private String value;
    @Value("${config.example.vars.value:this-is-default-vars-value}")
    private String varsValue;
    @Value("${config.example.secrets.value:this-is-default-secrets-value}")
    private String secretsValue;

    @GetMapping("/api/hello")
    public ResponseEntity<?> hello(@RequestParam(required = false, defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name);
    }

    @GetMapping("/api/value")
    public ResponseEntity<?> value() {
        Map<String, String> map = new HashMap<>();
        map.put("value", value);
        map.put("varsValue", varsValue);
        map.put("secretsValue", secretsValue);
        return ResponseEntity.ok(map);
    }

}
