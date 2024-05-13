package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISemesterRepository extends JpaRepository<Semester, Integer> {
}
