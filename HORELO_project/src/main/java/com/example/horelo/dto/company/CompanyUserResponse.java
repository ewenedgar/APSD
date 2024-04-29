package com.example.horelo.dto.company;

import com.example.horelo.dto.user.UserCompanyResponse;
import com.example.horelo.dto.user.UserResponse;

import java.util.List;

public record CompanyUserResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        String Visibility,

        List<UserResponse> user
) {
}
