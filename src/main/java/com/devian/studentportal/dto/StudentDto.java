package com.devian.studentportal.dto;

import com.devian.studentportal.model.StudentEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private StudentEntity.Gender gender;
    private String civilStatus;
    private String profilePicture;
    private String mobileNumber;
    private String homeNumber;
    private String email;
    private String barangay;
    private String street;
    private String city;
    private String province;
    private String zipCode;
    private Boolean graduating;
    private String studentIDNumber;
    private String course;
    private StudentEntity.Status status;
}
