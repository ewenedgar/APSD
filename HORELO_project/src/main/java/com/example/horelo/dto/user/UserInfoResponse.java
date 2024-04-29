package com.example.horelo.dto.user;

import com.example.horelo.dto.address.AddressResponse;
import com.example.horelo.dto.allergy.AllergyResponse;

import java.util.List;

public record UserInfoResponse(
        Long user_id,
        String first_name,
        String last_name,
        String phone_number,
        String email,
        AddressResponse primary_address,
        List<AllergyResponse> allergy

) {


}
