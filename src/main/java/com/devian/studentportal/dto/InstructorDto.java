package com.devian.studentportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String course;

}
