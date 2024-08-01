package com.project.odontologia.models.material;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);

    Material toEntity(MaterialCreationDTO materialCreationDTO);

    Material toEntity(MaterialUpdateDTO materialUpdateDTO);

    MaterialDTO toDTO(Material material);
}

