package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Student;
import com.lab.diemdanh.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    public List<Student> getAllStudents() {return iStudentRepository.findAll();};


}
