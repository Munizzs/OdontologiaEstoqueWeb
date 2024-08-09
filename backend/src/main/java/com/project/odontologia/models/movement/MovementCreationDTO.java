package com.project.odontologia.models.movement;

import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.material.Material;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class MovementCreationDTO {
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TransactionType type;
    @Min(value = 0, message = "Amount should not be less than 0")
    private Integer amount;
    @PastOrPresent(message = "Date should not be in the future")
    private LocalDate date;
    @NotBlank(message = "Material is mandatory") @ManyToOne
    @JoinColumn(name = "materialId", nullable = false)
    private Material material;
    @NotBlank(message = "Dentist is mandatory") @ManyToOne @JoinColumn(name = "dentistId", nullable = false)
    private Dentist dentist;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public @Min(value = 0, message = "Amount should not be less than 0") Integer getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 0, message = "Amount should not be less than 0") Integer amount) {
        this.amount = amount;
    }

    public @PastOrPresent(message = "Date should not be in the future") LocalDate getDate() {
        return date;
    }

    public void setDate(@PastOrPresent(message = "Date should not be in the future") LocalDate date) {
        this.date = date;
    }

    public @NotBlank(message = "Material is mandatory") Material getMaterial() {
        return material;
    }

    public void setMaterial(@NotBlank(message = "Material is mandatory") Material material) {
        this.material = material;
    }

    public @NotBlank(message = "Dentist is mandatory") Dentist getDentist() {
        return dentist;
    }

    public void setDentist(@NotBlank(message = "Dentist is mandatory") Dentist dentist) {
        this.dentist = dentist;
    }
}
