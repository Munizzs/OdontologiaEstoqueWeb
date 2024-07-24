package com.project.odontologia.services;

import com.project.odontologia.models.movement.InventoryTransactions;
import com.project.odontologia.models.movement.RequestMovement;
import com.project.odontologia.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {
    
    private final MovementRepository repository;

    @Autowired
    public MovementService(MovementRepository repository) {
        this.repository = repository;
    }

    public List<InventoryTransactions> findAll(){
        return repository.findAll();
    }

    public Optional<InventoryTransactions> findById(Integer id){
        var transactionsId = repository.findById(id);
        if(transactionsId.isPresent()){
            return transactionsId;
        }else{
            return null;
        }
    }

    public InventoryTransactions save(InventoryTransactions transactions){
        return repository.save(transactions);
    }

    public Optional<InventoryTransactions> update(Integer id, RequestMovement movement){
        return findById(id).map(mov -> {
            if(!(movement.type()==null)){
                mov.setType(movement.type());
            }
            mov.setAmount(movement.amount());
            if(!(movement.date()==null)){
                mov.setDate(movement.date());
            }
            if(!(movement.material()==null)){
                mov.setMaterial(movement.material());
            }
            if(!(movement.dentist()==null)){
                mov.setDentist(movement.dentist());
            }
            return repository.save(mov);
        });
    }

    public void removeById(Integer id){
        repository.deleteById(id);
    }
}
