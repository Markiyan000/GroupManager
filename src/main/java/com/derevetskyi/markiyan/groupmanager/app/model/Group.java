package com.derevetskyi.markiyan.groupmanager.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "group_")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_creation")
    private LocalDate dateOfCreation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id")
    private Teacher curator;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students;

    public Group() {

    }

    public Group(String name, LocalDate dateOfCreation) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
