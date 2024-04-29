package com.example.horelo.dto.orderItem;

import com.example.horelo.dto.company.CompanyResponse;
import com.example.horelo.dto.company.CompanyResponseIdName;
import com.example.horelo.model.Price;

public record FoodItemResponse(
        Long orderItem_id,
        String name,
        String spice_level,
        String cuisine_type,

        int quantity,
        String description,
        String availability,
        String visibility,
        Price price,
        CompanyResponseIdName company
) {
}
