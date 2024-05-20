package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Student;
import com.lab.diemdanh.Repository.IClassSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSubjectService {
    @Autowired
    private IClassSubjectRepository classSubjectRepository;

    public List<Student> getStudentsByClassId(int classId) {
        return classSubjectRepository.findStudentsByClassId(classId);
    }

    public List<Integer> findIdByClassID(int id) {
        return classSubjectRepository.findIdByClassID(id);
    }
}
