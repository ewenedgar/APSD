package com.example.horelo.dto.user;

import com.example.horelo.dto.order.CustomerOrderResponse2;

import java.util.List;

public record UserOrderResponse(
        Long user_id,
        String first_name,
        String last_name,
        String phone_number,
        String email,
        List<CustomerOrderResponse2> customerOrders_list
) {
}
