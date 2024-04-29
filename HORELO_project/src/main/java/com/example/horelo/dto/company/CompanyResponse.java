package com.example.horelo.dto.company;

public record CompanyResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        String Visibility
) {
}
