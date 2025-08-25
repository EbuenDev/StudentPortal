package com.devian.studentportal.repo;

import com.devian.studentportal.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository <StudentEntity, Long>{

}
