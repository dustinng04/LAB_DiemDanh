package com.lab.diemdanh.Service;

import com.lab.diemdanh.Entity.Subjects;
import com.lab.diemdanh.Repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private ISubjectRepository subjectRepository;

    public List<Subjects> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subjects getSubjectsByCode(String code) {
        return subjectRepository.getSubjectsByCode(code);
    }

    public List<Subjects> getSubjectsByName(String name) {
        return subjectRepository.getSubjectsByName(name);
    }

    public Subjects saveSubject(Subjects subjects) {
        return subjectRepository.save(subjects);
    }

    public void deleteSubject(String code) {
        Subjects subject = subjectRepository.getSubjectsByCode(code);
        if (subject != null) {
            subjectRepository.delete(subject);
        }
    }
}
