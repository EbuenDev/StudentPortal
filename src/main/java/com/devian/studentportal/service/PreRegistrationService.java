package com.devian.studentportal.service;


import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreRegistrationService {

    private final StudentRepository studentRepository;

}
