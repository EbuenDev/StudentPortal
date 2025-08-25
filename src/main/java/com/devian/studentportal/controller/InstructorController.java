package com.devian.studentportal.controller;


import com.devian.studentportal.dto.InstructorDto;
import com.devian.studentportal.dto.InstructorRegisterDto;
import com.devian.studentportal.model.InstructorEntity;
import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.service.InstructorService;
import com.devian.studentportal.utility.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {


    private final InstructorService instructorService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping
    public List<InstructorDto> getAlliInstructors() {
        return instructorService.getAllInstructors()
                .stream()
                .map(InstructorMapper::toDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable Long id) {
        return ResponseEntity.ok(InstructorMapper.toDto(instructorService.getInstructorById(id)));
    }


    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorRegisterDto registerDto) {
        InstructorEntity instructorEntity = InstructorMapper.fromRegisterDto(registerDto);
//        instructorEntity.setPassword(bCryptPasswordEncoder.encode(instructorEntity.getPassword()));
        InstructorEntity savedInstructor = instructorService.registerInstructor(instructorEntity);
        return ResponseEntity.ok(InstructorMapper.toDto(savedInstructor));
    }

}
