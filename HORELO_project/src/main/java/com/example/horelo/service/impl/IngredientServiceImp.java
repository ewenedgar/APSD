package com.example.horelo.service.impl;

import com.example.horelo.dto.ingredient.IngredientResponse;
import com.example.horelo.model.Ingredient;
import com.example.horelo.service.inface.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImp implements IngredientService {
    @Override
    public Ingredient addNewIngredient(Ingredient newIngredient) {
        return null;
    }

    @Override
    public List<IngredientResponse> getAllIngredients() {
        return null;
    }
}
