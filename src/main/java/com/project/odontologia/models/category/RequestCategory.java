package com.project.odontologia.models.category;

import jakarta.validation.constraints.NotBlank;

public record RequestCategory(
        @NotBlank(message = "Name is mandatory") String nome,
        String description
)
{}
