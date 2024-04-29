package com.example.horelo.service.inface;

import com.example.horelo.dto.ingredient.IngredientResponse;
import com.example.horelo.model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient addNewIngredient(Ingredient newIngredient);
    List<IngredientResponse> getAllIngredients();
}
