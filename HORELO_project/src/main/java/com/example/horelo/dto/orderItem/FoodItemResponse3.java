package com.example.horelo.dto.orderItem;

import com.example.horelo.model.Price;

public record FoodItemResponse3(
        Long orderItem_id,
        String name,
        String spice_level,
        String cuisine_type,

        int quantity,
        String description,
        String availability,
        String visibility,
        Price price
) {
}
