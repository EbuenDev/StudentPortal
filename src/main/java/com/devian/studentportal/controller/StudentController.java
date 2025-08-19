package com.devian.studentportal.controller;


import com.devian.studentportal.dto.StudentDto;
import com.devian.studentportal.dto.StudentRegisterDto;
import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.service.StudentService;
import com.devian.studentportal.utility.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // Get All Students
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get Sing Student by Id
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentEntity studentEntity = studentService.getStudentById(id);
        if (studentEntity != null) {
            return ResponseEntity.ok(StudentMapper.toDto(studentEntity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Register Student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentRegisterDto registerDto) {
        StudentEntity student = StudentMapper.fromRegisterDto(registerDto);
        StudentEntity savedStudent = studentService.registerStudent(student); // service handles password hashing
        return ResponseEntity.ok(StudentMapper.toDto(savedStudent));
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentEntity) {
        StudentEntity updatedStudentEntity = studentService.saveStudent(studentEntity);

        if (updatedStudentEntity != null) {
            studentEntity.setId(id);
            return ResponseEntity.ok(updatedStudentEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}