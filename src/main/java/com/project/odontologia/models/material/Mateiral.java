package com.project.odontologia.models.material;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Mateiral {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Min(value = 0, message = "Amount should not be less than 0")
    private int amount;
    @Future(message = "Date must be in the future")
    private LocalDate validitye;
    @NotBlank(message = "Code is mandatory")
    private String code;

    public Mateiral() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    @Min(value = 0, message = "Amount should not be less than 0")
    public int getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 0, message = "Amount should not be less than 0") int amount) {
        this.amount = amount;
    }

    public @Future(message = "Date must be in the future") LocalDate getValiditye() {
        return validitye;
    }

    public void setValiditye(@Future(message = "Date must be in the future") LocalDate validitye) {
        this.validitye = validitye;
    }

    public @NotBlank(message = "Code is mandatory") String getCode() {
        return code;
    }

    public void setCode(@NotBlank(message = "Code is mandatory") String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Mateiral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", validitye=" + validitye +
                ", code='" + code + '\'' +
                '}';
    }
}
