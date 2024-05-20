package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Plan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlanImportController {

    @GetMapping("api/plan/import")
    public String viewImportForm() {
        return "import-plan";
    }
}
