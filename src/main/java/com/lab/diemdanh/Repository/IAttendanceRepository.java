package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Integer> {
}
