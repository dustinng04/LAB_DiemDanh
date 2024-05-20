package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Semester;
import com.lab.diemdanh.Repository.ISemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {
    @Autowired
    ISemesterRepository semesterRepository;

    public Semester findById(int id) {
        return semesterRepository.findById(id).get();
    }
}
