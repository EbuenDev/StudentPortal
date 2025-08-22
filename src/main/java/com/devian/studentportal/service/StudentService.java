package com.devian.studentportal.service;

import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public List<StudentEntity> getAllStudents(){return studentRepository.findAll();}

    public StudentEntity getStudentById(Long id){return studentRepository.findById(id).orElse(null);}

    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return studentEntity;
    }
    public void deleteStudentById(Long id){studentRepository.deleteById(id);}

    public StudentEntity registerStudent(StudentEntity studentEntity){
        studentEntity.setPassword(bCryptPasswordEncoder.encode(studentEntity.getPassword()));
        return studentRepository.save(studentEntity);
    }

}
