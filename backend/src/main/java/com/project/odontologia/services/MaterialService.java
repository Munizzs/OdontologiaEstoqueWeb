package com.project.odontologia.services;

import com.project.odontologia.models.material.*;
import com.project.odontologia.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    private final MaterialRepository repository;
    private final MaterialMapper mapper;

    @Autowired
    public MaterialService(MaterialRepository repository, MaterialMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MaterialDTO> findAll(){
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MaterialDTO findById(Integer id){
        Material material = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item com id " + id + " não existe."));
        return mapper.toDTO(material);
    }

    public MaterialDTO save(MaterialCreationDTO materialCreationDTO){
        Material material = mapper.toEntity(materialCreationDTO);
        repository.save(material);
        return mapper.toDTO(material);
    }

    public MaterialDTO update(Integer id, MaterialUpdateDTO materialUpdateDTO){
        Material material = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item com id " + id + " não existe."));

        if (materialUpdateDTO.getName() != null)
            material.setName(materialUpdateDTO.getName());

        if (materialUpdateDTO.getAmount() != null)
            material.setAmount(materialUpdateDTO.getAmount());

        if (materialUpdateDTO.getCategory() != null)
            material.setCategory(materialUpdateDTO.getCategory());

        repository.save(material);

        return mapper.toDTO(material);
    }

    public void removeById(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Item com id " + id + " não existe.");
    }
}
