package com.devian.studentportal.utility;


import com.devian.studentportal.dto.StudentDto;
import com.devian.studentportal.dto.StudentRegisterDto;
import com.devian.studentportal.model.StudentEntity;

public class StudentMapper {

    public static StudentDto toDto(StudentEntity entity) {
        if (entity == null) return null;

        return StudentDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .mobileNumber(entity.getMobileNumber())
                .email(entity.getEmail())
                .course(entity.getCourse())
                .build();
    }


    public static StudentEntity fromRegisterDto(StudentRegisterDto dto) {
        if (dto == null) return null;

        return StudentEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mobileNumber(dto.getMobileNumber())
                .email(dto.getEmail())
                .course(dto.getCourse())
                .password(dto.getPassword()) // will be hashed in service layer
                .build();

    }
}
