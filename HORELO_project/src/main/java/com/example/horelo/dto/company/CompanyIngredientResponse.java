package com.example.horelo.dto.company;

import com.example.horelo.dto.ingredient.IngredientResponse;
import com.example.horelo.dto.item.ItemResponse;
import com.example.horelo.model.Ingredient;

import java.util.List;

public record CompanyIngredientResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        List<IngredientResponse> ingredient
) {
}
