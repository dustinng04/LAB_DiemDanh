package com.lab.diemdanh.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "schedule_id")
    private int scheduleId;

    //    tinyint checked
    @Column(name = "checked")
    private boolean checked;

    @Column(name = "note")
    private String note;

    public Attendance() {
    }

    public Attendance(int id, String studentId, int scheduleId, boolean checked, String note) {
        this.id = id;
        this.studentId = studentId;
        this.scheduleId = scheduleId;
        this.checked = checked;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
