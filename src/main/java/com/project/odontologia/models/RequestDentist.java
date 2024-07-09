package com.project.odontologia.models;

import jakarta.validation.constraints.NotNull;

public record RequestDentist(
        @NotNull String name,
        @NotNull String specialty,
        @NotNull String cro,
        @NotNull String email,
        @NotNull String password
){}
