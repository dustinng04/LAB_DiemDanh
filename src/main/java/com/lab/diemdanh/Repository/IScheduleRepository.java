package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

}
