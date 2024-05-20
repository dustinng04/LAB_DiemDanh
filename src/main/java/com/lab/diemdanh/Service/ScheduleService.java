package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.ClassSubject;
import com.lab.diemdanh.Entity.Schedule;
import com.lab.diemdanh.Entity.Student;
import com.lab.diemdanh.Repository.IClassSubjectRepository;
import com.lab.diemdanh.Repository.IScheduleRepository;
import com.lab.diemdanh.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired
    private IClassSubjectRepository classSubjectRepository;

    @Autowired
    private IStudentRepository studentRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    public List<Schedule> getScheduleForWeek(LocalDate startOfWeek) {
        LocalDate start = startOfWeek;
        LocalDate end = start.plusDays(6);
        return scheduleRepository.findByStartTimeBetween(start, end);
    }

    public List<Schedule> getScheduleOfStudent(LocalDate startOfWeek, String studentId) {
        LocalDate start = startOfWeek;
        LocalDate end = start.plusDays(6);
        List<ClassSubject> classSubjects = classSubjectRepository.findAll();
        List<Integer> classSubjectId = new ArrayList<>();
        Student stu = studentRepository.findById(studentId).get();
        for (ClassSubject cs : classSubjects) {
            if (cs.getStudents().contains(stu)) {
                classSubjectId.add(cs.getId());
                System.out.println("$$$$$$$" + cs.getId());
            }
        }

        List<Schedule> schedules = new ArrayList<>();

        for (int i : classSubjectId) {
            schedules.addAll(scheduleRepository.findScheduleOfClass(start,end,i));
        }

        return schedules;
    }
}
