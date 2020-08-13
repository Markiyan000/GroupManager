package com.derevetskyi.markiyan.groupmanager.app.repository;

import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t join fetch t.subjects where t.id = :id")
    Optional<Teacher> findById(@Param(value="id") Long id);
}
