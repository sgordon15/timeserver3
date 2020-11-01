package com.example.timeserver.controller;

import com.example.timeserver.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.*;
import java.util.TimeZone;



@RestController
@RequestMapping("/api/v1")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")

    public String getTime() { //gets time in utc
        Instant utcTime = Instant.now();
        String finalTime = utcTime.toString();
        System.out.println(finalTime);
        return finalTime;
    }


    @GetMapping("/epochTime")
    public Long getEpochTime() {
        return timeService.getEpochTime();

    }
    public String getTimeZone() {

        LocalDateTime timeInZone = LocalDateTime.now(TimeZone.getTimeZone("America/New_York").toZoneId());
        Instant time = Instant.now();
        System.out.println("Time in New York:" +timeInZone);
        return timeInZone.toString();

    }
}
