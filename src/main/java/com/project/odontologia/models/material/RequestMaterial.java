package com.project.odontologia.models.material;

import com.project.odontologia.models.category.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record RequestMaterial(
        @NotBlank(message = "Name is mandatory") String name,
        @Min(value = 0, message = "Amount should not be less than 0") Integer amount,
        @NotBlank(message = "Category is mandatory") @ManyToOne @JoinColumn(name = "category_id", nullable = false) Category category
) {}
