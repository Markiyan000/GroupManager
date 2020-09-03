package com.derevetskyi.markiyan.groupmanager.app.repository;

import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t left join fetch t.subjects where t.id = :id")
    Optional<Teacher> findById(@Param(value="id") Long id);

    @Query("select t from Teacher t where t.id not in (select g.curator from Group g where g.curator is not null)")
    List<Teacher> findAllNotCurators();
}
