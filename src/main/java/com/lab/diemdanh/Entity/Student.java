package com.lab.diemdanh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "major")
    private String major;

    @Column(name = "image_link")
    private String image;

    public Student(String id, String major, String image) {
        this.id = id;
        this.major = major;
        this.image = image;
    }

    public Student() {
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
}
