package com.example.horelo.dto.company;


import com.example.horelo.dto.order.CustomerOrderResponse;

import java.util.List;

public record CompanyOrderResponse(
        Long company_id,
        String phone_number,
        String name,
        String email,
        List<CustomerOrderResponse> order
) {
}
