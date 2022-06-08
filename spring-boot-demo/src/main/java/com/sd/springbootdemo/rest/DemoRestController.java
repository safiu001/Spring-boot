package com.sd.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class DemoRestController {

    @GetMapping("/")
    public String helloRest(){
        return "Hello World! Welcome to Spring boot, "+ LocalTime.now();
    }
}
