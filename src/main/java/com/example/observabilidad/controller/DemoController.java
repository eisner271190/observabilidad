package com.example.observabilidad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    public DemoController() {}

    @GetMapping
    public String demoEndpoint() {
        return "Hola Mundo";
    }
}
