package com.derevetskyi.markiyan.groupmanager.app.repository;

import com.derevetskyi.markiyan.groupmanager.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student where group_id is null", nativeQuery = true)
    List<Student> findAllWithoutGroup();
}
