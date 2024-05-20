package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Schedule;
import com.lab.diemdanh.Entity.Semester;
import com.lab.diemdanh.Repository.IScheduleRepository;
import com.lab.diemdanh.Repository.ISemesterRepository;
import com.lab.diemdanh.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleViewController {

    @Autowired
    IScheduleRepository scheduleRepository;
    @Autowired
    SemesterService semesterService;
    @GetMapping("/schedule/{studentId}")
    public String getSchedulePage(ModelMap modelMap, @PathVariable String studentId) {
        List<String> scheduleTime = new ArrayList<>();
        Semester s = semesterService.findById(1);
        LocalDate currentDate = s.getStartDate();
        while (!currentDate.isAfter(s.getEndDate())) {
            scheduleTime.add(currentDate + " to " + currentDate.plusDays(6));
            currentDate = currentDate.plusDays(7);
        }

        modelMap.addAttribute("weeks",scheduleTime);
        modelMap.addAttribute("studentId", studentId);
        return "schedule";
    }
}
