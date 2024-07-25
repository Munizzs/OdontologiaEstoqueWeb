package com.project.odontologia.controllers;

import com.project.odontologia.exceptions.ResourceNotFoundException;
import com.project.odontologia.models.movement.InventoryTransactions;
import com.project.odontologia.models.movement.RequestMovement;
import com.project.odontologia.services.MovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/moviment")
public class MovimentController {

    private final MovementService service;

    @Autowired
    public MovimentController(MovementService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        var allMoviment = service.findAll();
        return ResponseEntity.ok(allMoviment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        var movimentId = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("status não encontrado com id " + id));
            return ResponseEntity.ok(movimentId);
    }

    @PostMapping
    public ResponseEntity<?> read(@RequestBody RequestMovement data){
        InventoryTransactions transactions = new InventoryTransactions(data);
        service.save(transactions);
        return ResponseEntity.status(201).body("Id "+transactions.getId()+" Criado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody RequestMovement data){
        var movimentUpdate = service.update(id, data);
            return ResponseEntity.ok(movimentUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
