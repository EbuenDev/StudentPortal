package com.devian.studentportal.service;

import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public List<StudentEntity> getAllStudents(){return studentRepository.findAll();}

    public StudentEntity getStudentById(Long id){return studentRepository.findById(id).orElse(null);}

    public StudentEntity saveStudent(StudentEntity studentEntity){return studentRepository.save(studentEntity);}

    public void deleteStudentById(Long id){studentRepository.deleteById(id);}
}
