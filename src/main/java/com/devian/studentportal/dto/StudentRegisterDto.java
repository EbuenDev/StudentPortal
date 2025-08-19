package com.devian.studentportal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegisterDto {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String password;
}
