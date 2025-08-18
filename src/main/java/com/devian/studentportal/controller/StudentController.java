package com.devian.studentportal.controller;


import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a contructor for the StudentController class.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        StudentEntity studentEntity = studentService.getStudentById(id);
        if (studentEntity != null) {
            return ResponseEntity.ok(studentEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
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