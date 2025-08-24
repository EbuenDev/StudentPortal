package com.devian.studentportal.dto;

import com.devian.studentportal.model.StudentEntity;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterDto {

    // Personal Information
    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    private String firstName;

    @Size(max = 100, message = "Middle name must not exceed 100 characters")
    private String middleName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name must not exceed 100 characters")
    private String lastName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender is required")
    private StudentEntity.Gender gender;

    @NotBlank(message = "Civil status is required")
    @Size(max = 20, message = "Civil status must not exceed 20 characters")
    private String civilStatus;

    private String profilePicture;

    // Contact Details
    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid mobile number format")
    private String mobileNumber;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid home number format")
    private String homeNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 150, message = "Email must not exceed 150 characters")
    private String email;

    // Password
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;

    // Address
    @NotBlank(message = "Barangay is required")
    @Size(max = 100, message = "Barangay must not exceed 100 characters")
    private String barangay;

    @NotBlank(message = "Street is required")
    @Size(max = 200, message = "Street must not exceed 200 characters")
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must not exceed 100 characters")
    private String city;

    @NotBlank(message = "Province is required")
    @Size(max = 100, message = "Province must not exceed 100 characters")
    private String province;

    @NotBlank(message = "Zip code is required")
    @Pattern(regexp = "^[0-9]{4}$", message = "Zip code must be 4 digits")
    private String zipCode;


    @NotBlank(message = "Student ID number is required")
    @Size(max = 20, message = "Student ID number must not exceed 20 characters")
    private String studentIDNumber;

    // Education Information
    @NotBlank(message = "Course is required")
    @Size(max = 100, message = "Course must not exceed 100 characters")
    private String course;
}