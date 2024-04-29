package com.example.horelo.dto.user;

import com.example.horelo.dto.allergy.AllergyResponse;

public record UserAllergyResponse (
        Long user_id,
        String first_name,
        String last_name,
        String phone_number,
        String email,
        AllergyResponse allergy
){
}
