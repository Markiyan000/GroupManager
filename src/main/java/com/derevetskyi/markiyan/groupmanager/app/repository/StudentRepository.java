package com.derevetskyi.markiyan.groupmanager.app.repository;

import com.derevetskyi.markiyan.groupmanager.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
