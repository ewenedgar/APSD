package com.example.horelo.dto.orderItem;

import com.example.horelo.dto.company.CompanyRequest;
import com.example.horelo.model.Price;

public record FoodItemRequest(
        String name,
        String spice_level,
        String cuisine_type,
        int quantity,
        Price price,
        String description,
        String availability,
        String visibility,
        CompanyRequest company
) {
}
