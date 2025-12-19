package com.sujon.SpringBootRestAPI.controller;
import java.util.concurrent.atomic.AtomicLong;

import com.sujon.SpringBootRestAPI.dto.GreetingRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public GreetingRecord greeting(@RequestParam(defaultValue="World") String name) {
        return new GreetingRecord(counter.incrementAndGet(), String.format(template, name));
    }
}
