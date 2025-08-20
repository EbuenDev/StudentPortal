package com.devian.studentportal.model;

import ch.qos.logback.core.status.Status;
import com.nimbusds.openid.connect.sdk.claims.Gender;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Personal Information of Student
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;


    // Contact Details of Student
    private String mobileNumber;
    private String homeNumber;
    private String email;

    @JsonIgnore
    private String password;


    // Address of Student
    private String barangay;
    private String street;
    private String city;
    private String province;
    private String zipCode;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Education Information of Student
    private String course;

    @Enumerated(EnumType.STRING)
    private Status status;


    public enum Gender {
        MALE,
        FEMALE;
    }

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }
}
