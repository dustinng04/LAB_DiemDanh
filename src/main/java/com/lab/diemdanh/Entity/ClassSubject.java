package com.lab.diemdanh.Entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Class_Subject")
public class ClassSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "class_id") // Specify a unique name for the join column
    private Class aClass;

    @ManyToOne
    @JoinColumn(name = "subject_id") // Specify a unique name for the join column
    private Subjects subject;

    @ManyToMany
    @JoinTable(
            name = "Class_Member",
            joinColumns = @JoinColumn(name = "class_subject_id"), // Specify a unique name for the join column
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    // Other properties, constructors, getters, and setters

}
