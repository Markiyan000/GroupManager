package com.derevetskyi.markiyan.groupmanager.app.service;

import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.model.Student;
import com.derevetskyi.markiyan.groupmanager.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private GroupService groupService;

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(GroupService groupService, StudentRepository studentRepository) {
        this.groupService = groupService;
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllWithoutGroup() {
        return studentRepository.findAllWithoutGroup();
    }

    @Transactional
    public Student saveStudent(Long groupId, Student student) {
        Group group = groupService.findById(groupId);
        group.addStudent(student);

        return student;
    }

    @Transactional
    public void transferToOtherGroup(Long studentId, String groupName) {
        Student student = studentRepository.findById(studentId).get();
        Group newGroup = groupService.findByName(groupName);

        newGroup.addStudent(student);
    }

    @Transactional
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
