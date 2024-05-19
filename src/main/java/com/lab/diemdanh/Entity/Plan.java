package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "class_name")
    private String className;
    @Column(name = "subject_id")
    private String subjectId;
    @Column(name = "dept")
    private String dept;
    @Column(name = "slotDays")
    private String slotDays;
    @Column(name = "slot1")
    private String slot1;
    @Column(name = "slot2")
    private String slot2;
    @Column(name = "room")
    private String room;
    @Column(name = "room2")
    private String room2;
    @Column(name = "semester_id")
    private int semesterId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Plan() {
    }

    public Plan(int id, String className, String subjectId, String dept, String slotDays, String slot1, String slot2, String room, String room2, int semesterId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.className = className;
        this.subjectId = subjectId;
        this.dept = dept;
        this.slotDays = slotDays;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.room = room;
        this.room2 = room2;
        this.semesterId = semesterId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSlotDays() {
        return slotDays;
    }

    public void setSlotDays(String slotDays) {
        this.slotDays = slotDays;
    }

    public String getSlot1() {
        return slot1;
    }

    public void setSlot1(String slot1) {
        this.slot1 = slot1;
    }

    public String getSlot2() {
        return slot2;
    }

    public void setSlot2(String slot2) {
        this.slot2 = slot2;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom2() {
        return room2;
    }

    public void setRoom2(String room2) {
        this.room2 = room2;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
