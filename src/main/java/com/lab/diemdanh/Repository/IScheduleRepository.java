package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
}
