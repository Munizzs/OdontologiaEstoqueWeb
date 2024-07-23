package com.project.odontologia.models.movement;

import com.project.odontologia.models.dentist.Dentist;
import com.project.odontologia.models.material.Material;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class InventoryTransactions {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TransactionType type;
    @Min(value = 0, message = "Amount should not be less than 0")
    private int amount;
    @PastOrPresent(message = "Date should not be in the future")
    private LocalDate date;
    @NotBlank(message = "Material is mandatory") @ManyToOne @JoinColumn(name = "materialId", nullable = false)
    private Material material;
    @NotBlank(message = "Dentist is mandatory") @ManyToOne @JoinColumn(name = "dentistId", nullable = false)
    private Dentist dentist;

    public InventoryTransactions() {
    }

    public InventoryTransactions(Integer id, TransactionType type, int amount, LocalDate date, Material material, Dentist dentist) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.material = material;
        this.dentist = dentist;
    }

    public InventoryTransactions(RequestMovement request) {
        this.type = request.type();
        this.amount = request.amount();
        this.date = request.date();
        this.material = request.material();
        this.dentist = request.dentist();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Min(value = 0, message = "Amount should not be less than 0")
    public int getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 0, message = "Amount should not be less than 0") int amount) {
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

    @Override
    public String toString() {
        return "InventoryTransactions{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", material=" + material +
                ", dentist=" + dentist +
                '}';
    }
}
