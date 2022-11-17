package com.tanseer.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String messages;

    @GetMapping("/")
    public String helloWorld(){
        return messages;
    }
}
