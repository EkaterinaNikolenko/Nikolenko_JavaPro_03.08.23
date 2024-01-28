package com.hillel.edu.springsecurity.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
    private static final Logger logger = Logger.getLogger(PingController.class);

    @GetMapping
    public String ping() {
        logger.info("Ping");
        return "OK";
    }
}
