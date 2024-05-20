package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Student;
import com.lab.diemdanh.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository studentRepository;
    public List<Student> getAllStudents() {return studentRepository.findAll();};


    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

}
