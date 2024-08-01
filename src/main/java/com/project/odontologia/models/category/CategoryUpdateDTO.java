package com.project.odontologia.models.category;

import jakarta.validation.constraints.Size;

public class CategoryUpdateDTO {
    @Size(min = 1, max = 50)
    private String nome;
    @Size(min = 1, max = 1000)
    private String description;

    public @Size(min = 1, max = 50) String getNome() {
        return nome;
    }

    public void setNome(@Size(min = 1, max = 50) String nome) {
        this.nome = nome;
    }

    public @Size(min = 1, max = 1000) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 1, max = 1000) String description) {
        this.description = description;
    }
}
