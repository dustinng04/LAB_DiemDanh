package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "techear_id")
    private String teacherId;

    @Column(name = "subject_id")
    private String subjectId;

    @Column(name = "class_id")
    private int classId;

    @Column(name = "slot")
    private int slot;

    @Column(name = "room")
    private String room;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "type")
    private String type;

    public Schedule() {
    }

    public Schedule(int id, String teacherId, String subjectId, int classId, int slot, String room, Timestamp startTime, Timestamp endTime, String type) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.classId = classId;
        this.slot = slot;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
