package com.example.horelo.dto.user;

import com.example.horelo.dto.address.AddressRequest;

public record UserAddressRequest(

        String first_name,
        String last_name,
        String phone_number,
        String email,
        AddressRequest primary_address

) {
}
