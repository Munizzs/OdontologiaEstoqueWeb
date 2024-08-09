package com.project.odontologia.services;

import com.project.odontologia.models.movement.*;
import com.project.odontologia.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementService {

    private final MovementRepository repository;
    private final MovementMapper mapper;

    @Autowired
    public MovementService(MovementRepository repository,MovementMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MovementDTO> findAll(){
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MovementDTO findById(Integer id){
        Movement movement = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Status com id " + id + " não existe."));
        return mapper.toDTO(movement);
    }

    public MovementDTO save(MovementCreationDTO movementCreationDTO){
        Movement movement = mapper.toEntity(movementCreationDTO);
        repository.save(movement);
        return mapper.toDTO(movement);
    }

    public MovementDTO update(Integer id, MovementUpdateDTO movementUpdateDTO){
        Movement movement = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Status com id " + id + " não existe."));

        if (movementUpdateDTO.getType() != null)
            movement.setType(movementUpdateDTO.getType());

        if (movementUpdateDTO.getAmount() != null)
            movement.setAmount(movementUpdateDTO.getAmount());

        if (movementUpdateDTO.getDate() != null)
            movement.setDate(movementUpdateDTO.getDate());

        if (movementUpdateDTO.getMaterial() != null)
            movement.setMaterial(movementUpdateDTO.getMaterial());

        if (movementUpdateDTO.getDentist() != null)
            movement.setDentist(movementUpdateDTO.getDentist());

        repository.save(movement);

        return mapper.toDTO(movement);
    }

    public void removeById(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Status com id " + id + " não existe.");
    }
}
