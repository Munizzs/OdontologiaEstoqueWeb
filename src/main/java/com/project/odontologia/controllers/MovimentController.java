package com.project.odontologia.controllers;

import com.project.odontologia.models.movement.InventoryTransactions;
import com.project.odontologia.models.movement.RequestMovement;
import com.project.odontologia.services.MovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/moviment")
public class MovimentController {

    @Autowired
    private MovementService service;

    @GetMapping
    public ResponseEntity getAll(){
        var allMoviment = service.findAll();
        return ResponseEntity.ok(allMoviment);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        var movimentId = service.findById(id);
        if (movimentId.isEmpty()){
            return ResponseEntity.notFound().build();

        }else {
            return ResponseEntity.ok(movimentId);
        }
    }

    @PostMapping
    public ResponseEntity read(@RequestBody RequestMovement data){
        InventoryTransactions transactions = new InventoryTransactions(data);
        var readTransactions = service.save(transactions);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @Valid @RequestBody RequestMovement data){
        var movimentUpdate = service.update(id, data);
        if (movimentUpdate.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(movimentUpdate);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.ok().build();
    }
}
