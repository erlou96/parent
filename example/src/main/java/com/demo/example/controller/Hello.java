package com.demo.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello world!";
    }


}


