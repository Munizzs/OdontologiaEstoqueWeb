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

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Optional<Category> findById(Integer id){
        var categoryId = repository.findById(id);
        if(categoryId.isPresent()){
            return categoryId;
        }else{
            return null;
        }
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Optional<Category> update(Integer id, RequestCategory category){
        return findById(id).map(categ -> {
            if(!(category.nome()==null)){
                categ.setNome(category.nome());
            }
            if(!(category.description()==null)){
                categ.setDescription(category.description());
            }
            return repository.save(categ);
        });
    }

    public void removeById(Integer id){
        repository.deleteById(id);
    }
}
