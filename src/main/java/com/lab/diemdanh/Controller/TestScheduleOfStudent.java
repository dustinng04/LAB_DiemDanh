package com.lab.diemdanh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestScheduleOfStudent {

    @GetMapping("/test-schedule")
    public String testSchedule() {

        return "index";
    }

}
