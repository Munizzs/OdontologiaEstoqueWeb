package com.project.odontologia.services;

import com.project.odontologia.models.Dentist;
import com.project.odontologia.models.RequestDentist;
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

    public Optional<Dentist> findById(Integer id) {

        if (repository.findById(id).isPresent())
            return repository.findById(id);
        else
            return null;
    }

    public Optional<Dentist> updateById(RequestDentist dentist, Integer id){
        Optional<Dentist> existingDentist = repository.findById(id);

        if (existingDentist.isPresent()) {
            Dentist user = existingDentist.get();
            user.setName(dentist.name());
            user.setSpecialty(dentist.specialty());
            user.setCro(dentist.cro());
            user.setEmail(dentist.email());
            user.setPassword(dentist.password());
            repository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Integer id){
        Optional<Dentist> existingDentist = repository.findById(id);

        if (existingDentist.isPresent()) {
            Dentist user = existingDentist.get();
            repository.delete(user);
        }
    }
}
