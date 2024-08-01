package com.project.odontologia.models.category;

import jakarta.validation.constraints.*;

public class CategoryCreationDTO {
    @NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50)
    private String nome;
    @Size(min = 1, max = 1000)
    private String description;

    public @NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50) String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
