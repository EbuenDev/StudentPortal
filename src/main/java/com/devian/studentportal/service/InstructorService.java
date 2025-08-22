package com.devian.studentportal.service;


import com.devian.studentportal.model.InstructorEntity;
import com.devian.studentportal.repo.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {


    
    private final InstructorRepository instructorRepository;
    private  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public List<InstructorEntity> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public InstructorEntity getInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public InstructorEntity updateInstructor(InstructorEntity instructorEntity) {
        return instructorRepository.save(instructorEntity);
    }


    public void deleteInstructorById(Long id) {
        instructorRepository.deleteById(id);
    }

    // Optional: Add a dedicated register method with password hashing
    public InstructorEntity registerInstructor(InstructorEntity instructorEntity) {
        instructorEntity.setPassword(bCryptPasswordEncoder.encode(instructorEntity.getPassword()));
        return instructorRepository.save(instructorEntity);
    }
}