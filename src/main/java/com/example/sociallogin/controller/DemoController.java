package com.example.sociallogin.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> sayHello(HttpServletRequest request) {
        long endTime = Instant.now().toEpochMilli();
        Long startTime = (Long) request.getAttribute("startTime");
        long duration = startTime != null ? endTime - startTime : 0;
        LOGGER.info("(end time): " + endTime);
        LOGGER.info("Duration: " + duration + " millis second");
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("timings.log", true))) {
//            writer.write("Start Time: " + startTime + ", End Time: " + endTime + ", Duration: " + duration + " seconds\n");
//        } catch (IOException e) {
//            LOGGER.error("Error writing to log file", e);
//        }

        return ResponseEntity.ok("Hello OAuth2");
    }
}
