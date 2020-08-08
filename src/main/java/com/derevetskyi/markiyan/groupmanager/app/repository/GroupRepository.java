package com.derevetskyi.markiyan.groupmanager.app.repository;

import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<Group, Long> {

}
