package com.example.timeserver.controller;

import com.example.timeserver.model.TimeResponse;
import com.example.timeserver.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@RestController
@RequestMapping("/api/v1")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime() {
        return timeService.getTime();
    }

    @GetMapping("/epochTime")
    public Long getEpochTime() {
        return timeService.getEpochTime();

    }
    @GetMapping("/timeZone")
    public String getTimeZone() {
        return timeService.getTimeZone("America/Chicago");
    }
    @GetMapping("/getTime")
    public TimeResponse getTimeResponse() {
        return timeService.getTimeResponse();
    }

}
