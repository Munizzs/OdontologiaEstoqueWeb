package com.project.odontologia.controllers;

import com.project.odontologia.exceptions.ResourceNotFoundException;
import com.project.odontologia.models.movement.InventoryTransactions;
import com.project.odontologia.models.movement.RequestMovement;
import com.project.odontologia.services.MovementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/moviment")
@Tag(name = "Movimentos", description = "API para gerenciamento de movimentos")
public class MovimentController {

    private final MovementService service;

    @Autowired
    public MovimentController(MovementService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os movimentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de movimentos",
                    content = {@Content(mediaType = "application/json")}
            )
    })
    @GetMapping
    public ResponseEntity<?> getAll(){
        var allMoviment = service.findAll();
        return ResponseEntity.ok(allMoviment);
    }

    @Operation(summary = "Obter movimento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do movimento",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Movimento não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        var movimentId = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("status não encontrado com id " + id));
            return ResponseEntity.ok(movimentId);
    }

    @Operation(summary = "Registrar um novo movimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movimento registrado com sucesso")
    })
    @PostMapping
    public ResponseEntity<?> read(@RequestBody RequestMovement data){
        InventoryTransactions transactions = new InventoryTransactions(data);
        service.save(transactions);
        return ResponseEntity.status(201).body("Id "+transactions.getId()+" Criado");
    }

    @Operation(summary = "Atualizar um movimento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimento atualizado com sucesso",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Movimento não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody RequestMovement data){
        var movimentUpdate = service.update(id, data);
            return ResponseEntity.ok(movimentUpdate);
    }

    @Operation(summary = "Remover um movimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movimento removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Movimento não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
