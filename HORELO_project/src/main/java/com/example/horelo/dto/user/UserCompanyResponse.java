package com.example.horelo.dto.user;

import com.example.horelo.dto.company.CompanyResponse;

public record UserCompanyResponse(
        Long user_id,
        String first_name,
        String last_name,
        String phone_number,
        String email,
        CompanyResponse company
) {
}
