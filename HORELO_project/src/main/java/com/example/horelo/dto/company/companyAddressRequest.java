package com.example.horelo.dto.company;

import com.example.horelo.dto.address.AddressRequest;

public record companyAddressRequest (
        String phone_number,
        String name,
        String email,
        String Visibility,
        AddressRequest primary_address

){

}
