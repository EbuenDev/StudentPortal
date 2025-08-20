package com.devian.studentportal.dto;

import com.devian.studentportal.model.InstructorEntity;
import com.nimbusds.openid.connect.sdk.claims.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private InstructorEntity.Gender gender;
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
    private String department;
    private InstructorEntity.Status status;
    private String instructorIDNumber;

}
