package com.project.odontologia.models.movement;

import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.material.Material;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.time.LocalDate;

public record RequestMovement(
        @NotNull @Enumerated(EnumType.STRING) TransactionType type,
        @Min(value = 0, message = "Amount should not be less than 0") Integer amount,
        @PastOrPresent(message = "Date should not be in the future") LocalDate date,
        @Valid Material material,
        @Valid Dentist dentist
) {}
