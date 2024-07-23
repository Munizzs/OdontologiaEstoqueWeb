package com.project.odontologia.models.movement;

import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.material.Material;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RequestMovement(
        @Enumerated(EnumType.STRING) @Column(nullable = false) TransactionType type,
        @Min(value = 0, message = "Amount should not be less than 0") int amount,
        @PastOrPresent(message = "Date should not be in the future") LocalDate date,
        @NotBlank(message = "Material is mandatory") @ManyToOne @JoinColumn(name = "materialId", nullable = false) Material material,
        @NotBlank(message = "Dentist is mandatory") @ManyToOne @JoinColumn(name = "dentistId", nullable = false) Dentist dentist
) {}
