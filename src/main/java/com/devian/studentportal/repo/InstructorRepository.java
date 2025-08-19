package com.devian.studentportal.repo;

import com.devian.studentportal.model.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository <InstructorEntity, Long>{
}
