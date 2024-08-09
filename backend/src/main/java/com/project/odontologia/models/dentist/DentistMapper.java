package com.project.odontologia.models.dentist;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DentistMapper {
    DentistMapper INSTANCE = Mappers.getMapper(DentistMapper.class);

    Dentist toEntity(DentistCreationDTO dentistCreationDTO);

    Dentist toEntity(DentistUpdateDTO dentistUpdateDTO);

    DentistDTO toDTO(Dentist dentist);
}
