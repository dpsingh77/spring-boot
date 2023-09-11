package com.diy.lawnmower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LawnMowerApplication {

    @GetMapping("/")
    public String home()
    {
        return "Welcome to first spring boot!";
    }
    public static void main(String[] args) {
        SpringApplication.run(LawnMowerApplication.class, args);
    }

}
