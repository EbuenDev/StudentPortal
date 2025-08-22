package com.devian.studentportal.utility;


import com.devian.studentportal.dto.InstructorDto;
import com.devian.studentportal.dto.InstructorRegisterDto;
import com.devian.studentportal.model.InstructorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstructorMapper {

    public static InstructorDto toDto(InstructorEntity entity) {
        if (entity == null) return null;

        return InstructorDto.builder()
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
                .department(entity.getDepartment())
                .status(entity.getStatus())
                .instructorIDNumber(entity.getInstructorIDNumber())
                .build();
    }

    public static InstructorEntity fromRegisterDto(InstructorRegisterDto dto) {
        if (dto == null) return null;

        return InstructorEntity.builder()
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
                .department(dto.getDepartment())
                .instructorIDNumber(dto.getInstructorIDNumber())
                .status(InstructorEntity.Status.ACTIVE) // Set default status for new registrations
                .build();
    }
}

