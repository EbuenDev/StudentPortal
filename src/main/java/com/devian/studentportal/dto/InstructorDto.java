package com.devian.studentportal.dto;

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

    private Gender gender;

    private String mobileNumber;
    private String email;
    private String course;

}
