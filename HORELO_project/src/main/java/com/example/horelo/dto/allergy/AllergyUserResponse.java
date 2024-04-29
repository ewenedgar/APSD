package com.example.horelo.dto.allergy;

import com.example.horelo.dto.user.UserAllergyResponse;
import com.example.horelo.dto.user.UserResponse;

public record AllergyUserResponse(
        Integer allergy_id,
        String name,
        String description,
        UserResponse user
) {
}
