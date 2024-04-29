package com.example.horelo.dto.ingredient;

import com.example.horelo.model.Company;

public record IngredientRequest(
        String name,
        Company company,
        String description,
        String serve_type
) {
}
