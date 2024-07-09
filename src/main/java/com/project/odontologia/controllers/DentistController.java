package com.project.odontologia.controllers;

import com.project.odontologia.models.Dentist;
import com.project.odontologia.models.RequestDentist;
import com.project.odontologia.services.DentistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    @GetMapping
    public ResponseEntity getAllDentist(){
        var listAll = service.listAll();
        return ResponseEntity.ok(listAll);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity registerDentist(@RequestBody @Valid RequestDentist data){
        Dentist dentist = new Dentist(data);
        service.save(dentist);
        return ResponseEntity.ok().build();
    }

    @PutMapping({"/{id}"})
    public ResponseEntity updateDentist(@RequestBody @Valid RequestDentist data,@PathVariable Integer id){
        var update = service.updateById(data,id);
        if(update.isPresent()){
            return ResponseEntity.ok(update);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity removeDentist(@PathVariable Integer id){
        service.deleteById(id);
            return ResponseEntity.ok().build();
    }
}
