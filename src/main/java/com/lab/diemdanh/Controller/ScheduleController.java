package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Schedule;
import com.lab.diemdanh.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;



    @GetMapping("/api/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }
    @GetMapping("/api/schedule")
    public List<Schedule> getSchedule(@RequestParam("startDate") String startDate) {
        LocalDate startOfWeek = LocalDate.parse(startDate); // Format: yyyy-MM-dd
        return scheduleService.getScheduleForWeek(startOfWeek);
    }

    @GetMapping("/api/schedule/{studentId}")
    public List<Schedule> getScheduleOfStudent(@RequestParam("startDate") String startDate, @PathVariable String studentId) {
        LocalDate startOfWeek = LocalDate.parse(startDate); // Format: yyyy-MM-dd

        return scheduleService.getScheduleOfStudent(startOfWeek, studentId);
    }
}
