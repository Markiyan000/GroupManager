package com.derevetskyi.markiyan.groupmanager.app.service;

import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;
import com.derevetskyi.markiyan.groupmanager.app.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).get();
    }

    public List<Teacher> findAllNotCurators() {
        return teacherRepository.findAllNotCurators();
    }


}
