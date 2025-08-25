package com.devian.studentportal.utility;

import com.devian.studentportal.dto.PreRegistrationDto;
import com.devian.studentportal.model.PreRegistrationEntity;

public class PreRegistrationMapper {

    public static PreRegistrationDto toDto(PreRegistrationEntity entity) {
        if (entity == null) return null;

        return PreRegistrationDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .course(entity.getCourse())
                .build();
    }

    public static PreRegistrationEntity registerDtoToEntity(PreRegistrationDto dto) {
        if (dto == null);

        return PreRegistrationEntity.builder()
                .email(dto.getEmail())
                .course(dto.getCourse())
                .build();
    }
}
