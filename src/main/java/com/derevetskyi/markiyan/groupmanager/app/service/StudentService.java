package com.derevetskyi.markiyan.groupmanager.app.service;

import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private GroupService groupService;

    @Autowired
    public StudentService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Transactional
    public Student saveStudent(Long groupId, Student student) {
        Group group = groupService.findById(groupId);
        group.addStudent(student);

        return student;
    }
}
