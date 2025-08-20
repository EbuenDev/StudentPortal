package com.devian.studentportal.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructors")
public class InstructorEntity {

    // Enums defined first for better structure
    public enum Gender {
        MALE,
        FEMALE
    }

    public enum Status {
        ACTIVE,
        INACTIVE,
        ON_LEAVE,
        DELETED
    }

    // Primary identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal Information
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String civilStatus;
    private String profilePicture;

    // Contact Information
    private String mobileNumber;
    private String homeNumber;
    private String email;

    // Security Information
    @JsonIgnore
    private String password;

    // Address Information
    private String barangay;
    private String street;
    private String city;
    private String province;
    private String zipCode;

    // Professional Information
    private String department;
    private String instructorIDNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
}