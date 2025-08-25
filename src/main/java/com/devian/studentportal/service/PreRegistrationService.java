package com.devian.studentportal.service;


import com.devian.studentportal.model.PreRegistrationEntity;
import com.devian.studentportal.model.StudentEntity;
import com.devian.studentportal.repo.PreRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreRegistrationService {

    @Autowired
    private final PreRegistrationRepository preRegistrationRepository;


    public PreRegistrationEntity getPreRegisterStudentById(Long id){return preRegistrationRepository.findById(id).orElse(null); }

    public List<PreRegistrationEntity> getAllPreRegisterStudent(){return preRegistrationRepository.findAll(); }

    public PreRegistrationEntity createPreRegisterStudent(PreRegistrationEntity preRegistrationEntity) {
        preRegistrationEntity.setVerificationStatus(PreRegistrationEntity.VerificationStatus.PENDING);
        preRegistrationEntity.setVerificationToken(UUID.randomUUID().toString());
        preRegistrationEntity.setTokenGeneratedAt(LocalDateTime.now());

        return preRegistrationRepository.save(preRegistrationEntity);

    }


}
