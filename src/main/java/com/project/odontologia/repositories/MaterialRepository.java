package com.project.odontologia.repositories;

import com.project.odontologia.models.material.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{
}
