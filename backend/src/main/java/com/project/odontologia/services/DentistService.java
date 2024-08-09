package com.project.odontologia.services;

import com.project.odontologia.models.dentist.*;
import com.project.odontologia.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DentistService {

    private final DentistRepository repository;
    private final DentistMapper mapper;

    @Autowired
    public DentistService(DentistRepository repository, DentistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DentistDTO> listAll(){
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public DentistDTO save(DentistCreationDTO dentistCreationDTO){
        Dentist dentist = mapper.toEntity(dentistCreationDTO);
        repository.save(dentist);
        return mapper.toDTO(dentist);
    }

    public DentistDTO findById(Integer id) {
        Dentist dentist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dentista com id " + id + " não existe."));
        return mapper.toDTO(dentist);
    }

    public DentistDTO updateById(Integer id, DentistUpdateDTO dentistUpdateDTO) {
        Dentist dentist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dentista com id " + id + " não existe."));

        if(dentistUpdateDTO.getName()!=null)
            dentist.setName(dentistUpdateDTO.getName());

        if (dentistUpdateDTO.getSpecialty() != null)
            dentist.setSpecialty(dentistUpdateDTO.getSpecialty());

        if (dentistUpdateDTO.getCro() != null)
            dentist.setCro(dentistUpdateDTO.getCro());

        if (dentistUpdateDTO.getEmail() != null)
            dentist.setEmail(dentistUpdateDTO.getEmail());

        if (dentistUpdateDTO.getPassword() != null)
            dentist.setPassword(dentistUpdateDTO.getPassword());

        repository.save(dentist);

        return mapper.toDTO(dentist);
    }

    public void removeById(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Dentista com id " + id + " não existe.");
    }
}
