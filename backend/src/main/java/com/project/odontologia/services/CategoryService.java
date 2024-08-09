package com.project.odontologia.services;

import com.project.odontologia.models.category.*;
import com.project.odontologia.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Autowired
    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CategoryDTO> findAll(){
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Integer id){
        Category category = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria com id " + id + " não existe."));
         return mapper.toDTO(category);
    }

    public CategoryDTO save(CategoryCreationDTO categoryCreationDTO){
        Category category = mapper.toEntity(categoryCreationDTO);
        category = repository.save(category);
        return mapper.toDTO(category);
    }

    public CategoryDTO update(Integer id, CategoryUpdateDTO categoryUpdateDTO){
        Category category = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria com id " + id + " não existe."));

        if(categoryUpdateDTO.getNome()!=null)
            category.setNome(categoryUpdateDTO.getNome());

        if(categoryUpdateDTO.getDescription()!=null)
            category.setDescription(categoryUpdateDTO.getDescription());

        repository.save(category);
        return mapper.toDTO(category);
    }

    public void removeById(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Categoria com id " + id + " não existe.");
    }
}
