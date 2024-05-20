package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "major")
    private String major;

    @Column(name = "image_link")
    private String image;

    @ManyToMany(mappedBy = "students")
    private List<ClassSubject> classSubjects;

    public Student() {
    }

    public Student(String id, String major, String image, List<ClassSubject> classSubjects) {
        this.id = id;
        this.major = major;
        this.image = image;
        this.classSubjects = classSubjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ClassSubject> getClassSubjects() {
        return classSubjects;
    }

    public void setClassSubjects(List<ClassSubject> classSubjects) {
        this.classSubjects = classSubjects;
    }

}
