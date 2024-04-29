package com.example.horelo.dto.user;

import com.example.horelo.dto.address.AddressResponse;

public record UserAddressResponse(
        Long user_id,
        String first_name,
        String last_name,
        String phone_number,
        String email,
        AddressResponse primary_address
) {
}
