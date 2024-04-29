package com.example.horelo.service.inface;

import com.example.horelo.dto.allergy.AllergyResponse;
import com.example.horelo.dto.allergy.AllergyUserResponse;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.Allergy;

import java.util.List;

public interface AllergyService {
    Allergy addNewAllergy(Allergy newAllergy);

    List<AllergyResponse> getAllAllergies();

    List<AllergyUserResponse> getAllergiesByUser();
}
