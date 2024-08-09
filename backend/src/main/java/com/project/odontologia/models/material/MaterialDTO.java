package com.project.odontologia.models.material;

import com.project.odontologia.models.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;

public class MaterialDTO{
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Min(value = 0, message = "Amount should not be less than 0")
    private Integer amount;
    @NotBlank(message = "Category is mandatory") @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

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

    public @Min(value = 0, message = "Amount should not be less than 0") Integer getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 0, message = "Amount should not be less than 0") Integer amount) {
        this.amount = amount;
    }

    public @NotBlank(message = "Category is mandatory") Category getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category is mandatory") Category category) {
        this.category = category;
    }
}
