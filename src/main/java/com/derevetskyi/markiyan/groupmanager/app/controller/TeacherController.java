package com.derevetskyi.markiyan.groupmanager.app.controller;

import com.derevetskyi.markiyan.groupmanager.app.dto.TeacherDto;
import com.derevetskyi.markiyan.groupmanager.app.dto.TeacherSmallDto;
import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;
import com.derevetskyi.markiyan.groupmanager.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherSmallDto> findAll() {
        List<Teacher> teachers = teacherService.findAll();

        return teachers.stream().map(TeacherSmallDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);

        return new TeacherDto(teacher);
    }
}
