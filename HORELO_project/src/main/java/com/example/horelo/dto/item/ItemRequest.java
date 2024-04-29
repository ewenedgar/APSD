package com.example.horelo.dto.item;

import com.example.horelo.model.Price;

public record ItemRequest(
        String name,
        String Description,
        Price price
) {
}
