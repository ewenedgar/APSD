package com.example.horelo.dto.company;

public record CompanyRequest(
        String phone_number,
        String name,
        String email,
        String Visibility
) {
}
