package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<Class, Integer> {
    // Class is entity class

}
