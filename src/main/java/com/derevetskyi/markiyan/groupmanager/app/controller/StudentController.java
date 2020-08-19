package com.derevetskyi.markiyan.groupmanager.app.controller;

import com.derevetskyi.markiyan.groupmanager.app.model.Student;
import com.derevetskyi.markiyan.groupmanager.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{groupId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student, @PathVariable Long groupId) {
        return studentService.saveStudent(groupId, student);
    }

    @GetMapping("/{studentId}/transfer/{groupId}")
    public void transferToOtherGroup(@PathVariable Long studentId, @PathVariable Long groupId) {
        studentService.transferToOtherGroup(studentId, groupId);
    }
}
