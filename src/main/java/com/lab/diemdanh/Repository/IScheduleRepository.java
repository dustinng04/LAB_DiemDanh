package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query("SELECT s FROM Schedule s WHERE DATE(s.startTime) >= DATE(:start) AND DATE(s.endTime) <= DATE(:end) ")
    List<Schedule> findByStartTimeBetween(LocalDate start, LocalDate end);

    @Query("SELECT s FROM Schedule s WHERE DATE(s.startTime) >= DATE(:start) AND DATE(s.endTime) <= DATE(:end) AND s.classId = :classId ORDER BY DAY(s.startTime), MONTH(s.startTime)")
    List<Schedule> findScheduleOfClass(LocalDate start, LocalDate end, int classId);

    @Query("SELECT s FROM Schedule s WHERE s.id = (SELECT MAX(id) FROM Schedule)")
    Schedule findScheduleWithMaxId();
}
