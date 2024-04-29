package com.example.horelo.dto.company;

import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.dto.orderItem.FoodItemResponse3;

import java.util.List;

public record CompanyOrderItemResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        List<FoodItemResponse3> order_item
) {
}
