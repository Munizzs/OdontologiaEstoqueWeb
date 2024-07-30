package com.project.odontologia.models.material;

import com.project.odontologia.models.category.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;

public record RequestMaterial(
        @NotBlank(message = "Name is mandatory") String name,
        @Min(value = 0, message = "Amount should not be less than 0") Integer amount,
        @Valid Category category
) {}
