package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Class;
import com.lab.diemdanh.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping("/classes")
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }
}
