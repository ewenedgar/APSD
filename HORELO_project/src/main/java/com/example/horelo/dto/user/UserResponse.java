package com.example.horelo.dto.user;

public record UserResponse(
        Long user_id,
        String first_name,
        String last_name,
        String phone_number,
        String email
) {
}
