package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

@Entity
public class Subjects {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "head_of_department")
    private String headOfDepartment;
    @Column(name = "category")
    private int category;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "totalSlot")
    private int totalSlot;
//    @Column(name = "status")
//    private boolean status;

    public Subjects() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalSlot() {
        return totalSlot;
    }

    public void setTotalSlot(int totalSlot) {
        this.totalSlot = totalSlot;
    }
}
