package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Subjects;
import com.lab.diemdanh.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subjects> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/subjects/{code}")
    public Subjects getSubjectsByCode(@PathVariable String code) {
        return subjectService.getSubjectsByCode(code);
    }

    @GetMapping("/subjects/search")
    public List<Subjects> findSubjectsByName(@RequestParam("name") String name) {
        return subjectService.getSubjectsByName(name);
    }

    @PostMapping("/subjects")
    public ResponseEntity<String> addSubject(@RequestBody Subjects subjects) {
        subjectService.saveSubject(subjects);
        if (subjectService.getSubjectsByCode(subjects.getCode()) != null) {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Success", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/subjects/{code}")
    public ResponseEntity<String> editSubject(@PathVariable String code, @RequestBody Subjects subjects) {
        subjects.setId(subjectService.getSubjectsByCode(code).getId());
        if (subjectService.saveSubject(subjects) != null) {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Success", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/subjects/{code}")
    public void deleteSubject(@PathVariable String code) {
        subjectService.deleteSubject(code);
    }

}
