package com.devian.studentportal.service;

import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public List<StudentEntity> getAllStudents(){return studentRepository.findAll();}

    public StudentEntity getStudentById(Long id){return studentRepository.findById(id).orElse(null);}

    public StudentEntity saveStudent(StudentEntity studentEntity){return studentRepository.save(studentEntity);}

    public void deleteStudentById(Long id){studentRepository.deleteById(id);}

    public StudentEntity registerStudent(StudentEntity studentEntity){
        studentEntity.setPassword(bCryptPasswordEncoder.encode(studentEntity.getPassword()));
        return studentRepository.save(studentEntity);
    }

//    public boolean login(String email, String rawPassword) {
//        StudentEntity student = StudentRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        return bCryptPasswordEncoder.matches(rawPassword, student.getPassword());
//    }
}
