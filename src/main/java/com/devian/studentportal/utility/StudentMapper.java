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
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .dateOfBirth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .civilStatus(entity.getCivilStatus())
                .profilePicture(entity.getProfilePicture())
                .mobileNumber(entity.getMobileNumber())
                .homeNumber(entity.getHomeNumber())
                .email(entity.getEmail())
                .barangay(entity.getBarangay())
                .street(entity.getStreet())
                .city(entity.getCity())
                .province(entity.getProvince())
                .zipCode(entity.getZipCode())
                .graduating(entity.getGraduating())
                .studentIDNumber(entity.getStudentIDNumber())
                .course(entity.getCourse())
                .status(entity.getStatus())
                .build();
    }

    public static StudentEntity fromRegisterDto(StudentRegisterDto dto) {
        if (dto == null) return null;

        return StudentEntity.builder()
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .gender(dto.getGender())
                .civilStatus(dto.getCivilStatus())
                .profilePicture(dto.getProfilePicture())
                .mobileNumber(dto.getMobileNumber())
                .homeNumber(dto.getHomeNumber())
                .email(dto.getEmail())
                .password(dto.getPassword()) // will be hashed in service layer
                .barangay(dto.getBarangay())
                .street(dto.getStreet())
                .city(dto.getCity())
                .province(dto.getProvince())
                .zipCode(dto.getZipCode())
                .studentIDNumber(dto.getStudentIDNumber())
                .course(dto.getCourse())
                .status(StudentEntity.Status.ACTIVE) // Set default status for new registrations
                .build();
    }

}
