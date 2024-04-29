package com.example.horelo.dto.item;

import com.example.horelo.model.Price;

public record ItemResponse(
        Long item_id,
        String name,
        String Description,
        int quantity,
        Price price
) {
}
