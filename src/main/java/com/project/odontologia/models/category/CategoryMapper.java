package com.project.odontologia.models.category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryCreationDTO categoryCreationDTO);

    Category toEntity(CategoryUpdateDTO categoryUpdateDTO);

    CategoryDTO toDTO(Category category);
}
