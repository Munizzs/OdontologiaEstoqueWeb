package com.project.odontologia.models.material;

import com.project.odontologia.models.category.Category;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Material {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Min(value = 0, message = "Amount should not be less than 0")
    private Integer amount;
    @NotBlank(message = "Category is mandatory") @ManyToOne @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Material() {
    }

    public Material(Integer id, String name, Integer amount, Category category) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public Material(RequestMaterial request) {
        this.name = request.name();
        this.amount = request.amount();
        this.category = request.category();
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
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 0, message = "Amount should not be less than 0") int amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", category=" + category +
                '}';
    }
}
