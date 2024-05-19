package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Integer> {

}
