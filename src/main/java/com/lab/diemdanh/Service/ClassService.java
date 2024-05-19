package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Class;
import com.lab.diemdanh.Repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    IClassRepository classRepository;

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    };
}
