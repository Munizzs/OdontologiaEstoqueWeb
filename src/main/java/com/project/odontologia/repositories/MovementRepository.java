package com.project.odontologia.repositories;

import com.project.odontologia.models.movement.InventoryTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<InventoryTransactions, Integer> {
}
