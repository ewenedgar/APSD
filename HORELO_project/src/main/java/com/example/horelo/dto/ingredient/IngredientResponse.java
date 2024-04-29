package com.example.horelo.dto.ingredient;

import com.example.horelo.model.Company;
import jakarta.persistence.OneToOne;

public record IngredientResponse(
        Long ingredient_id,
        String name,
        Company company,
        String description,
        String serve_type
) {
}
