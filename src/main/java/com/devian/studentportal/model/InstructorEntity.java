package com.devian.studentportal.model;


import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nimbusds.openid.connect.sdk.claims.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructors")
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    // Personal Information of Instructor
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    // Contact Details of Instructor
    private String mobileNumber;
    private String email;

    @JsonIgnore
    private String password;


    // Address of Instructor
    private String barangay;
    private String street;
    private String city;
    private String province;
    private String zipCode;
    

    // Education Information of Instructor
    private String department;


    @Enumerated(EnumType.STRING)
    private Status status;


    public enum Gender {
        MALE,
        FEMALE;
    }

    public enum Status {
        ACTIVE,
        INACTIVE,
        ON_LEAVE,
        DELETED;
    }
}
