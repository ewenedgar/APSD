package com.example.horelo.dto.address;

import com.example.horelo.dto.company.CompanyAddressResponse;
import com.example.horelo.dto.company.CompanyResponse;
import com.example.horelo.dto.user.UserAddressResponse;

public record AddressCompanyResponse (
    Long addressId,
    String street,
    String city,
    String state,
    String zipCode,

    CompanyResponse company
){

}
