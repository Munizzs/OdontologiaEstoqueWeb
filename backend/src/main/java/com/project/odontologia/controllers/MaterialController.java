package com.project.odontologia.controllers;

import com.project.odontologia.exceptions.ResourceNotFoundException;
import com.project.odontologia.models.material.Material;
import com.project.odontologia.models.material.MaterialCreationDTO;
import com.project.odontologia.models.material.MaterialDTO;
import com.project.odontologia.models.material.MaterialUpdateDTO;
import com.project.odontologia.services.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/material")
@Tag(name = "Material", description = "API para gerenciamento de material")
public class MaterialController {

    private final MaterialService service;

    @Autowired
    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os materiais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de materiais",
                    content = {@Content(mediaType = "application/json")}
            )
    })
    @GetMapping
    public ResponseEntity<?> getAll(){
        var allMaterial = service.findAll();
        return ResponseEntity.ok(allMaterial);
    }

    @Operation(summary = "Obter material por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do material",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Material não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        var materialId = service.findById(id);
            return ResponseEntity.ok(materialId);
    }

    @Operation(summary = "Registrar um novo material")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Material registrado com sucesso")
    })
    @PostMapping
    public ResponseEntity<?> read(@Valid @RequestBody MaterialCreationDTO materialCreationDTO){
        MaterialDTO materialDTO = service.save(materialCreationDTO);
        return ResponseEntity.status(201).body("Id "+materialDTO.getId()+" Criado");
    }

    @Operation(summary = "Atualizar um material existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Material atualizado com sucesso",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Material não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @Valid @RequestBody MaterialUpdateDTO materialUpdateDTO){
        MaterialDTO materialDTO = service.update(id,materialUpdateDTO);
            return ResponseEntity.ok(materialDTO);
    }

    @Operation(summary = "Remover um material")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Material removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Material não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
