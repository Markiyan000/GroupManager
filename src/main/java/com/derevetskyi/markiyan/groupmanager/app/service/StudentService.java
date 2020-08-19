package com.derevetskyi.markiyan.groupmanager.app.service;

import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.model.Student;
import com.derevetskyi.markiyan.groupmanager.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private GroupService groupService;

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(GroupService groupService, StudentRepository studentRepository) {
        this.groupService = groupService;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student saveStudent(Long groupId, Student student) {
        Group group = groupService.findById(groupId);
        group.addStudent(student);

        return student;
    }

    @Transactional
    public void transferToOtherGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).get();

        Group oldGroup = student.getGroup();
        Group newGroup = groupService.findById(groupId);

        oldGroup.removeStudent(student);
        newGroup.addStudent(student);
    }
}
