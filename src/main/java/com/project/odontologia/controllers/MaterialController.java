package com.project.odontologia.controllers;

import com.project.odontologia.models.material.Material;
import com.project.odontologia.models.material.RequestMaterial;
import com.project.odontologia.services.MaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/material")
public class MaterialController {

    private final MaterialService service;

    @Autowired
    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        var allMaterial = service.findAll();
        return ResponseEntity.ok(allMaterial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        var materialId = service.findById(id);
        if(materialId.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(materialId);
        }
    }

    @PostMapping
    public ResponseEntity<?> read(@Valid @RequestBody RequestMaterial data){
        Material material = new Material(data);
        service.save(material);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @Valid @RequestBody RequestMaterial data){
        var materialModify = service.update(id,data);
            return ResponseEntity.ok(materialModify);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
