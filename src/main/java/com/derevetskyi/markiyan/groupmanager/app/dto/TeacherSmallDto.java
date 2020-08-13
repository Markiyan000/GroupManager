package com.derevetskyi.markiyan.groupmanager.app.dto;

import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;

public class TeacherSmallDto {

    private Long id;

    private String firstName;

    private String lastName;

    private int experience;

    public TeacherSmallDto(Teacher teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
        this.experience = teacher.getExperience();
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
