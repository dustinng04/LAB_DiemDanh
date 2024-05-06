package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_code")
    private String code;

    @Column(name = "subject_name")
    private String name;

    @Column(name = "head_of_department")
    private String headOfDepartment;

    @Column(name = "major")
    private String major;

    @Column(name = "status")
    private boolean status;

    public Subjects() {
    }

    public Subjects(Long id, String code, String name, String headOfDepartment, String major, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.headOfDepartment = headOfDepartment;
        this.major = major;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
