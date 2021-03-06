package com.derevetskyi.markiyan.groupmanager.app.service;

import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;
import com.derevetskyi.markiyan.groupmanager.app.repository.GroupRepository;
import com.derevetskyi.markiyan.groupmanager.app.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GroupService {

    private GroupRepository groupRepository;

    private TeacherRepository teacherRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, TeacherRepository teacherRepository) {
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(Long id) {
        return groupRepository.findById(id).get();
    }

    public Group findByName(String groupName) {
        return groupRepository.findByName(groupName);
    }

    @Transactional
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    public void addCurator(Long groupId, Long curatorId) {
        Teacher curatorProxy = teacherRepository.getOne(curatorId);
        Group group = findById(groupId);

        group.setCurator(curatorProxy);
    }

    @Transactional
    public void removeGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
