package com.example.horelo.dto.address;

public record AddressRequest(
        String street,
        String city,
        String state,
        String zipCode
) {
}
