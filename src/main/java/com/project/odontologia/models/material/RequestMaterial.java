package com.project.odontologia.models.material;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RequestMaterial(
        @NotBlank(message = "Name is mandatory") String name,
        @Min(value = 0, message = "Amount should not be less than 0") int amount,
        @Future(message = "Date must be in the future") LocalDate validitye,
        @NotBlank(message = "Code is mandatory") String code
) {}
