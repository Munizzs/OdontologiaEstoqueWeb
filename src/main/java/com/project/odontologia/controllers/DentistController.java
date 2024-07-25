package com.project.odontologia.controllers;

import com.project.odontologia.exceptions.ResourceNotFoundException;
import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.dentist.RequestDentist;
import com.project.odontologia.services.DentistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController @RequestMapping("/dentist")
@Tag(name = "Odontólogos", description = "API para gerenciamento de odontólogos")
public class DentistController {

    private final DentistService service;

    @Autowired
    public DentistController(DentistService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os dentistas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de dentistas",
                    content = {@Content(mediaType = "application/json")}
            )
    })
    @GetMapping
    public ResponseEntity<?> getAllDentist(){
        var listAll = service.listAll();
        return ResponseEntity.ok(listAll);
    }

    @Operation(summary = "Obter dentista por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do dentista",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Dentista não encontrado")
    })
    @GetMapping({"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        var dentist = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com id " + id));
        return ResponseEntity.ok(dentist);
    }

    @Operation(summary = "Registrar um novo dentista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dentista registrado com sucesso")
    })
    @PostMapping
    public ResponseEntity<?> registerDentist(@RequestBody @Valid RequestDentist data){
        Dentist dentist = new Dentist(data);
        service.save(dentist);
        return ResponseEntity.status(201).body("Id "+dentist.getId()+" Criado");
    }

    @Operation(summary = "Atualizar um dentista existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dentista atualizado com sucesso",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Dentista não encontrado")
    })
    @PutMapping({"/{id}"})
    public ResponseEntity<?> updateDentist(@PathVariable Integer id, @RequestBody @Valid RequestDentist data){
        var updatedDentist = service.updateById(id, data);
            return ResponseEntity.ok(updatedDentist);
    }

    @Operation(summary = "Remover um dentista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dentista removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dentista não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDentist(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
