package com.example.horelo.dto.address;

public record AddressResponse(
        Long addressId,
        String street,
        String city,
        String state,
        String zipCode
) {
}
