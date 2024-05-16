package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "Slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    public Slot(int id, Time endTime, Time startTime) {
        this.id = id;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public Slot() {

    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
