package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Attendance;
import com.lab.diemdanh.Service.AttendanceService;
import com.lab.diemdanh.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/attendances")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }
}
