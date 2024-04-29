package com.example.horelo.dto.orderItem;

public record FoodItemResponse2(
        Long orderItem_id,
        String name,
        String spice_level,
        String cuisine_type,

        int quantity,
        String description
) {
}
