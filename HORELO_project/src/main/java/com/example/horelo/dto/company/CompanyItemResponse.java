package com.example.horelo.dto.company;

import com.example.horelo.dto.item.ItemResponse;

import java.util.List;

public record CompanyItemResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        List<ItemResponse> item
) {
}
