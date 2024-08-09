package com.project.odontologia.models.material;

import com.project.odontologia.models.category.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MaterialUpdateDTO {
    private String name;
    @Min(value = 0, message = "Amount should not be less than 0")
    private Integer amount;
    @ManyToOne @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Min(value = 0, message = "Amount should not be less than 0") Integer getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 0, message = "Amount should not be less than 0") Integer amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
