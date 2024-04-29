package com.example.horelo.dto.order;

import com.example.horelo.dto.item.ItemResponse;
import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.dto.user.UserResponse;

import java.time.LocalDateTime;
import java.util.List;

public record CustomerOrderRequest(
        //Long customerOrder_id,
        String status,
        LocalDateTime date_time,
        String delivery_type, //in-house / pick up
        String special_requests,
        String payment_type,
        double total_price,
        double discount,
        UserResponse user,

        List<FoodItemResponse> orderItemList,

        List<ItemResponse> itemList
){
}
