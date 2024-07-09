package com.project.odontologia.controllers;

import com.project.odontologia.models.Dentist;
import com.project.odontologia.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    @GetMapping
    public List<Dentist> listAll(){
        return service.listAll();
    }

    @GetMapping({"/id"})
    public

    @PostMapping
    public Dentist create(@RequestBody Dentist dentist){
        return service.save(dentist);
    }





}
