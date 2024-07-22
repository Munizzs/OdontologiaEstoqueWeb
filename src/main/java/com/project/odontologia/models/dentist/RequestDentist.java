package com.project.odontologia.models.dentist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RequestDentist(

        @NotBlank(message = "Speciality is mandatory") String specialty,
        @NotBlank(message = "CRO is mandatory") @Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters") String cro,
        @NotBlank(message = "Name is mandatory") String name,
        @NotBlank(message = "Email is mandatory") String email,
        @NotBlank(message = "Password is mandatory") String password
){}
