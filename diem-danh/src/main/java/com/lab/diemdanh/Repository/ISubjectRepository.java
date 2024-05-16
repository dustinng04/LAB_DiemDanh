package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubjectRepository extends JpaRepository<Subjects,Long> {

    @Query(value = "SELECT * FROM subjects WHERE subject_code = :code", nativeQuery = true)
    Subjects getSubjectsByCode(String code);

    @Query(value = "SELECT * FROM subjects WHERE subject_name like %:name%", nativeQuery = true)
    List<Subjects> getSubjectsByName(String name);

}
