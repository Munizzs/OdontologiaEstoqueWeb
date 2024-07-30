package com.project.odontologia.services;

import com.project.odontologia.models.category.Category;
import com.project.odontologia.models.category.RequestCategory;
import com.project.odontologia.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Optional<Category> findById(Integer id){
         return repository.findById(id);
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Category update(Integer id, RequestCategory category){
        return findById(id).map(categ -> {
            if(category.nome()!=null)
                categ.setNome(category.nome());

            if(category.description()!=null)
                categ.setDescription(category.description());

            return repository.save(categ);
        }).orElseThrow(() -> new IllegalArgumentException("Categoria com id " + id + " não existe."));
    }

    public void removeById(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Categoria com id " + id + " não existe.");
    }
}
