package com.project.odontologia.services;

import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.dentist.RequestDentist;
import com.project.odontologia.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private final DentistRepository repository;

    @Autowired
    public DentistService(DentistRepository repository) {
        this.repository = repository;
    }

    public List<Dentist> listAll(){
        return repository.findAll();
    }

    public Dentist save(Dentist dentist){
        return repository.save(dentist);
    }

    public Optional<Dentist> findById(Integer id) {
            return repository.findById(id);
    }

    public Dentist updateById(Integer id, RequestDentist dentist) {
        return findById(id).map(user -> {
            if(dentist.name()!=null)
                user.setName(dentist.name());

            if(dentist.specialty()!=null)
                user.setSpecialty(dentist.specialty());

            if(dentist.cro()!=null)
                user.setCro(dentist.cro());

            if(dentist.email()!=null)
                user.setEmail(dentist.email());

            if(dentist.password()!=null)
                user.setPassword(dentist.password());

            return repository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("Dentista com id " + id + " não existe."));
    }

    public void removeById(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Dentista com id " + id + " não existe.");
    }
}
