package com.devian.studentportal.model;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pre_registrations")
public class PreRegistrationEntity {

    public enum VerificationStatus {
        PENDING,   // Email not yet verified
        VERIFIED,  // Email confirmed
        EXPIRED    // Link expired
    }

    // Primary identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Security Information
    private String email;
    @JsonIgnore
    private String password;

    // Academic Information
    private String course;


    // Pre-registration tracking
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;

    private String verificationToken; // token for email verification

    private LocalDateTime tokenGeneratedAt; // optional: for expiry tracking

}
