package com.project.odontologia.models.movement;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    Movement toEntity(MovementCreationDTO movementCreationDTO);

    Movement toEntity(MovementUpdateDTO movementUpdateDTO);

    MovementDTO toDTO(Movement movement);
}
