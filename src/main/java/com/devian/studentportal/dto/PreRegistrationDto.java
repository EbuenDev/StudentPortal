package com.devian.studentportal.dto;

import com.devian.studentportal.model.PreRegistrationEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreRegistrationDto {

    private Long id;
    private String email;
    private String course;
    private PreRegistrationEntity.VerificationStatus verificationStatus;
}
