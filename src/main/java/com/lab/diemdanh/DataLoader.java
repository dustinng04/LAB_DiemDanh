package com.lab.diemdanh;

import com.lab.diemdanh.Entity.Plan;
import com.lab.diemdanh.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PlanService planService;

    @Override
    public void run(String... args) throws Exception {
//        Plan samplePlan1 = new Plan(1, "SE1823", "SWR302", "SE", "P24", "Mon", "Wed", "BE-409", "BE-413", 1, LocalDate.parse("2024-05-06"), LocalDate.parse("2024-07-10"));
//        planService.addPlan(samplePlan1);
//        Plan samplePlan2 = new Plan(0, "SE1823", "SWT301", "SE", "P42", "Wed", "Mon", "BE-409", "", 1, LocalDate.parse("2024-05-06"), LocalDate.parse("2024-07-10"));
//        planService.addPlan(samplePlan2);
//        Plan samplePlan3 = new Plan(1, "SE1823", "PRN212", "SE", "P35", "Tue", "Thur", "BE-409", "BE-413", 1, LocalDate.parse("2024-05-06"), LocalDate.parse("2024-07-10"));
//        planService.addPlan(samplePlan3);
//        Plan samplePlan4 = new Plan(0, "SE1823", "SWP302", "SE", "P53", "Thur", "Tue", "BE-409", "", 1, LocalDate.parse("2024-05-06"), LocalDate.parse("2024-07-10"));
//        planService.addPlan(samplePlan4);
        System.out.println("Sample plan added and schedules generated.");
    }
}
