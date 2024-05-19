package com.lab.diemdanh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleViewController {
    @GetMapping("/schedule")
    public String getSchedulePage() {
        return "schedule";
    }
}
