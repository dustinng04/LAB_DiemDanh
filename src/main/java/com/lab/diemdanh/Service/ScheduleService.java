package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Schedule;
import com.lab.diemdanh.Repository.IScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    public List<Schedule> getScheduleForWeek(LocalDate startOfWeek) {
        LocalDateTime start = startOfWeek.atStartOfDay();
        LocalDateTime end = start.plusDays(6).with(LocalTime.MAX);
        return scheduleRepository.findByStartTimeBetween(start, end);
    }
}
