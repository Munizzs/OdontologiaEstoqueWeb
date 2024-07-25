package com.project.odontologia.controllers;

import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.dentist.RequestDentist;
import com.project.odontologia.services.DentistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController @RequestMapping("/dentist")
public class DentistController {

    private final DentistService service;

    @Autowired
    public DentistController(DentistService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllDentist(){
        var listAll = service.listAll();
        return ResponseEntity.ok(listAll);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Dentist> dentist = service.findById(id);
        if (dentist.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(dentist);
        }
    }

    @PostMapping
    public ResponseEntity<?> registerDentist(@RequestBody @Valid RequestDentist data){
        Dentist dentist = new Dentist(data);
        service.save(dentist);
        return ResponseEntity.status(201).build();
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> updateDentist(@PathVariable Integer id, @RequestBody @Valid RequestDentist data){
        var updatedDentist = service.updateById(id, data);
            return ResponseEntity.ok(updatedDentist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDentist(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
