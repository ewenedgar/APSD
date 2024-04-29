package com.example.horelo.service.inface;

import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.model.FoodItem;

import java.util.List;

public interface FoodItemService {
    FoodItem addNewFoodItem(FoodItem newOrderItem);
    List<FoodItemResponse> getAllFoodItems();
    List<FoodItemResponse> getFoodItemsByCompany(Long id);
}
