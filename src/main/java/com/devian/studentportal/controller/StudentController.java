package com.devian.studentportal.controller;


import com.devian.studentportal.dto.StudentDto;
import com.devian.studentportal.dto.StudentRegisterDto;
import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.service.StudentService;
import com.devian.studentportal.utility.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {


    private final StudentService studentService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

    // Get Sing Student by I'd
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
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentEntity studentEntity) {

        // First, check if students exist
        StudentEntity existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }

        // Set the ID from path variable to ensure we're updating the correct student
        studentEntity.setId(id);

        // Handle password properly - if password is being updated, hash it
        if (studentEntity.getPassword() != null && !studentEntity.getPassword().isEmpty()) {
            String hashedPassword = passwordEncoder.encode(studentEntity.getPassword());
            studentEntity.setPassword(hashedPassword);
        } else {
            // Keep the existing password if not provided in update
            studentEntity.setPassword(existingStudent.getPassword());
        }

        StudentEntity updatedStudent = studentService.updateStudent(studentEntity);
        return ResponseEntity.ok(StudentMapper.toDto(updatedStudent));
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}