package com.devian.studentportal.model;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pre_registrations")
public class PreRegistrationEntity {

    public enum Gender {
        MALE,
        FEMALE
    }

    public enum VerificationStatus {
        PENDING,   // Email not yet verified
        VERIFIED,  // Email confirmed
        EXPIRED    // Link expired
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

    // Contact Information
    private String mobileNumber;
    private String email;


    // Security Information
    @JsonIgnore
    private String password;

    // Pre-registration tracking
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;

    private String verificationToken; // token for email verification

    private LocalDateTime tokenGeneratedAt; // optional: for expiry tracking

    // Academic Information
    private String course;
}
