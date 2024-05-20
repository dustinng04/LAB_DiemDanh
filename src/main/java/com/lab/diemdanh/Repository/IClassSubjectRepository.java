package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.ClassSubject;
import com.lab.diemdanh.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface IClassSubjectRepository extends JpaRepository<ClassSubject,Integer> {
    @Query("SELECT cs.students FROM ClassSubject cs WHERE cs.aClass.id = :classId")
    List<Student> findStudentsByClassId(@Param("classId") int classId);

    @Query("SELECT cs.id FROM ClassSubject cs WHERE cs.aClass.id = :classId AND cs.subject.id = :subjectId")
    List<Integer> findIdByClassIdAndSubjectId(@Param("classId") int classId, @Param("subjectId") String subjectId);

    @Query("SELECT cs.id FROM ClassSubject cs WHERE cs.aClass.id = :classId")
    List<Integer> findIdByClassID(@Param("classId") int classId);

}
