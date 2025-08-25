package com.devian.studentportal.controller;


import com.devian.studentportal.dto.PreRegistrationDto;
import com.devian.studentportal.model.PreRegistrationEntity;
import com.devian.studentportal.service.PreRegistrationService;
import com.devian.studentportal.utility.PreRegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/pre-registration")
public class PreRegistrationController {

    private final PreRegistrationService preRegistrationService;

    @Autowired
    public PreRegistrationController(PreRegistrationService preRegistrationService) {
        this.preRegistrationService = preRegistrationService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PreRegistrationDto> studentPreRegistrationById(@PathVariable Long id) {
        PreRegistrationEntity preRegistrationEntity = preRegistrationService.getPreRegisterStudentById(id);

        if (preRegistrationEntity != null) {
            return ResponseEntity.ok(PreRegistrationMapper.toDto(preRegistrationEntity));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<PreRegistrationDto> getAllPreRegisterStudents() {
            return preRegistrationService.getAllPreRegisterStudent()
                    .stream()
                    .map(PreRegistrationMapper::toDto)
                    .collect(Collectors.toList());
    }
}
