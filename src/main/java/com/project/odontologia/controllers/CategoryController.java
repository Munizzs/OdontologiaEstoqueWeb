package com.project.odontologia.controllers;

import com.project.odontologia.models.category.Category;
import com.project.odontologia.models.category.RequestCategory;
import com.project.odontologia.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        var allCategory = service.findAll();
        return ResponseEntity.ok(allCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        var categoryId = service.findById(id);
        if (categoryId.isEmpty()){
            return ResponseEntity.notFound().build();

        }else {
            return ResponseEntity.ok(categoryId);
        }
    }

    @PostMapping
    public ResponseEntity<?> read(@RequestBody RequestCategory data){
        Category category = new Category(data);
        var readCategory = service.save(category);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody RequestCategory data){
        var categoryUpdate = service.update(id, data);
            return ResponseEntity.ok(categoryUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
