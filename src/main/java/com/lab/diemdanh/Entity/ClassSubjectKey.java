package com.lab.diemdanh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ClassSubjectKey implements Serializable {
    @Column(name = "classId")
    private int classId;

    @Column(name = "subjectId")
    private int subjectId;
}
