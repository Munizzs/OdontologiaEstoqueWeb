package com.project.odontologia.controllers;

import com.project.odontologia.exceptions.ResourceNotFoundException;
import com.project.odontologia.models.category.Category;
import com.project.odontologia.models.category.CategoryCreationDTO;
import com.project.odontologia.models.category.CategoryDTO;
import com.project.odontologia.models.category.CategoryUpdateDTO;
import com.project.odontologia.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/category")
@Tag(name = "Categoria", description = "API para gerenciamento de categoria")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas as categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorias",
                    content = {@Content(mediaType = "application/json")}
            )
    })
    @GetMapping
    public ResponseEntity<?> getAll(){
        var allCategory = service.findAll();
        return ResponseEntity.ok(allCategory);
    }

    @Operation(summary = "Obter categoria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes da categoria",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        var categoryId = service.findById(id);
        return ResponseEntity.ok(categoryId);
    }

    @Operation(summary = "Registrar um nova categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria registrada com sucesso")
    })
    @PostMapping
    public ResponseEntity<?> read(@RequestBody CategoryCreationDTO categoryCreationDTO){
        CategoryDTO categoryDTO = service.save(categoryCreationDTO);
        return ResponseEntity.status(201).body("Id "+categoryDTO.getId()+" Criado");
    }

    @Operation(summary = "Atualizar uma categoria existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody CategoryUpdateDTO categoryUpdateDTO){
        var categoryUpdate = service.update(id, categoryUpdateDTO);
            return ResponseEntity.ok(categoryUpdate);
    }

    @Operation(summary = "Remover uma categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categotia removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
