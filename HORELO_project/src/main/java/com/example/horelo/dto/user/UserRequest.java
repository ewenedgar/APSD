package com.example.horelo.dto.user;

public record UserRequest(
        String first_name,
        String last_name,
        String phone_number,
        String email
) {
}
