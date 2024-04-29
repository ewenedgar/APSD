package com.example.horelo.dto.item;

import com.example.horelo.dto.company.CompanyResponse;
import com.example.horelo.model.Price;

public record ItemCompanyResponse(
        Long item_id,
        String name,
        String Description,
        Price price,
        CompanyResponse company
) {
}
