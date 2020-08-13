package com.derevetskyi.markiyan.groupmanager.app.dto;

import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;

import java.util.List;

public class TeacherDto {

    private Long id;

    private String firstName;

    private String lastName;

    private List<String> subjects;

    public TeacherDto(Teacher teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
        this.subjects = teacher.getSubjects();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
