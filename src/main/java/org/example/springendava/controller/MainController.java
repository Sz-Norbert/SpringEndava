package org.example.springendava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, welcome to kubernetes!";
    }


    @GetMapping("/health")
    public String health() {
        return "Application is healthy!";
    }
}
