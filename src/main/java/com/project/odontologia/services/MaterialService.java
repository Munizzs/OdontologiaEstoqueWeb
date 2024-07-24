package com.project.odontologia.services;

import com.project.odontologia.models.material.Material;
import com.project.odontologia.models.material.RequestMaterial;
import com.project.odontologia.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    private final MaterialRepository repository;

    @Autowired
    public MaterialService(MaterialRepository repository) {
        this.repository = repository;
    }

    public List<Material> findAll(){
        return repository.findAll();
    }

    public Optional<Material> findById(Integer id){
        var materialId = repository.findById(id);
        if(materialId.isPresent()){
            return materialId;
        }else{
            return null;
        }
    }

    public Material save(Material material){
        return repository.save(material);
    }

    public Optional<Material> update(Integer id, RequestMaterial material){
        return findById(id).map(item -> {
            if(!(material.name()==null)){
                item.setName(material.name());
            }
                item.setAmount(material.amount());
            if(!(material.category()==null)){
                item.setCategory(material.category());
            }
            return repository.save(item);
        });
    }

    public void removeById(Integer id){
        repository.deleteById(id);
    }
}
