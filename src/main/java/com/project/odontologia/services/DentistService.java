package com.project.odontologia.services;

import com.project.odontologia.models.Dentist;
import com.project.odontologia.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    @Autowired
    private DentistRepository repository;

    public List<Dentist> listAll(){
        return repository.findAll();
    }

    public Dentist save(Dentist dentist){
        return repository.save(dentist);
    }

    public Optional<Dentist> findById(Integer id){
        return repository.findById(id);
    }


}
