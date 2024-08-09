package com.project.odontologia.models.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50)
    private String nome;
    @Size(min = 1, max = 1000)
    private String description;

    public Category() {
    }

    public Category(Integer id, String nome, String description) {
        this.id = id;
        this.nome = nome;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Name is mandatory") String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
