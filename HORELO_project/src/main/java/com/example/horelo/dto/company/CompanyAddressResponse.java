package com.example.horelo.dto.company;

import com.example.horelo.dto.address.AddressResponse;

public record CompanyAddressResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        AddressResponse primary_address
) {
}
