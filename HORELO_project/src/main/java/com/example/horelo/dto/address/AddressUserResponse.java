package com.example.horelo.dto.address;

import com.example.horelo.dto.user.UserAddressResponse;
import com.example.horelo.dto.user.UserAllergyResponse;
import com.example.horelo.dto.user.UserRequest;
import com.example.horelo.dto.user.UserResponse;

public record AddressUserResponse(
        Long addressId,
        String street,
        String city,
        String state,
        String zipCode,

        UserResponse user

) {
}
