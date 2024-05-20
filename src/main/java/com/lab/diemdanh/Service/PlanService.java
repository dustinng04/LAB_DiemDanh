package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.*;
import com.lab.diemdanh.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlanService {
    @Autowired
    private IPlanRepository planRepository;
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Autowired
    private ISlotRepository slotRepository;
    @Autowired
    private IClassRepository classRepository;
    @Autowired
    private IAttendanceRepository attendanceRepository;

    @Autowired
    private IClassSubjectRepository subjectClassRepository;
    // Test
    public Plan addPlan(Plan plan) {
        Plan savedPlan = planRepository.save(plan);

        // Generate the schedules based on the saved plan
        List<Slot> slots = slotRepository.findAll();
        List<Schedule> schedules = generateSchedules(savedPlan, slots);

        // Save the generated schedules
        for (Schedule s : schedules) {
            scheduleRepository.save(s);
            Schedule newestSchedule = scheduleRepository.findScheduleWithMaxId();
            List<Student> students = subjectClassRepository.findStudentsByClassId(newestSchedule.getClassId());
            for (Student stu : students) {
                Attendance a = new Attendance(stu.getId(), newestSchedule.getId(), false, "");
                attendanceRepository.save(a);
            }
        }

        return savedPlan;
    }

    private List<Schedule> generateSchedules(Plan plan, List<Slot> slots) {
        List<Schedule> schedules = new ArrayList<>();
        String[] slotDaysArray = plan.getSlotDays().split(",");


        for (String slotDay : slotDaysArray) {
            char period = slotDay.charAt(0); // 'P' or 'A'
            int firstDay = Character.getNumericValue(slotDay.charAt(1)); // First day of the week
            int secondDay = Character.getNumericValue(slotDay.charAt(2)); // Second day of the week

            // Determine slot IDs based on period
            int firstSlotId = (period == 'P') ? 3 : 1; // Morning: Slot 1, Afternoon: Slot 3
            int secondSlotId = (period == 'P') ? 4 : 2; // Morning: Slot 2, Afternoon: Slot 4

            // Map days to DayOfWeek
            Map<Integer, DayOfWeek> dayMap = Map.of(
                    2, DayOfWeek.MONDAY,
                    3, DayOfWeek.TUESDAY,
                    4, DayOfWeek.WEDNESDAY,
                    5, DayOfWeek.THURSDAY,
                    6, DayOfWeek.FRIDAY
            );

            LocalDate currentDate = plan.getStartDate();
            while (!currentDate.isAfter(plan.getEndDate())) {
                DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

                if (currentDayOfWeek == dayMap.get(firstDay)) {
                    addSchedule(plan, schedules, slots, currentDate, firstSlotId, true);
                }
                if (currentDayOfWeek == dayMap.get(secondDay)) {
                    addSchedule(plan, schedules, slots, currentDate, secondSlotId, false);
                }

                currentDate = currentDate.plusDays(1);
            }
        }

        return schedules;
    }

    private void addSchedule(Plan plan, List<Schedule> schedules, List<Slot> slots, LocalDate currentDate, int slotId, boolean isFirstDay) {
        Slot slot = slots.stream()
                .filter(s -> s.getId() == slotId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid slot ID: " + slotId));

        LocalDateTime startDateTime = LocalDateTime.of(currentDate, slot.getStartTime());
        LocalDateTime endDateTime = LocalDateTime.of(currentDate, slot.getEndTime());
        // Check room for firstDay/Second day and if room 2 is not typed
        String room = isFirstDay ? plan.getRoom() : (plan.getRoom2().isEmpty() ? plan.getRoom() : plan.getRoom2());
        int classId = classRepository.getClassByName(plan.getClassName()).getId();
        List<Integer> classSubId = subjectClassRepository.findIdByClassIdAndSubjectId(classId,plan.getSubjectId());
        for (int i : classSubId) {
            Schedule schedule = new Schedule(0, plan.getId(), null, plan.getSubjectId(), i, slotId, room, startDateTime, endDateTime, null);
            schedules.add(schedule);
        }
    }

}
