package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/example2/hello")
    public String hello() {
        return "Hello World by kua bao!";
    }
}
