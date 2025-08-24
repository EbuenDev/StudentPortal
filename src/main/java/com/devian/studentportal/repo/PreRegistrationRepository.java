package com.devian.studentportal.repo;

import com.devian.studentportal.model.PreRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreRegistrationRepository extends JpaRepository <PreRegistrationEntity, Long>{
    Optional<PreRegistrationEntity>findByEmail(String email);
    Optional<PreRegistrationEntity>findByVerificationToken(String verificationToken);
}
