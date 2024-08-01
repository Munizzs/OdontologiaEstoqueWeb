package com.project.odontologia.models.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDTO {
    private Integer id;
    @NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50)
    private String nome;
    @Size(min = 1, max = 1000)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Name is mandatory") @Size(min = 1, max = 50) String nome) {
        this.nome = nome;
    }

    public @Size(min = 1, max = 1000) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 1, max = 1000) String description) {
        this.description = description;
    }
}
