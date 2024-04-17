package edu.miu.cs.cs489.lab7.adsapp.dto.user;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
