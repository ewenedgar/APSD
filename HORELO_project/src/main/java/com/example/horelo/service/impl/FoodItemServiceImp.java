package com.example.horelo.service.impl;

import com.example.horelo.dto.company.CompanyResponse;
import com.example.horelo.dto.company.CompanyResponseIdName;
import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.model.FoodItem;
import com.example.horelo.respository.FoodItemRepository;
import com.example.horelo.service.inface.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FoodItemServiceImp implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Override
    public FoodItem addNewFoodItem(FoodItem newOrderItem) {
        return null;
    }

    @Override
    public List<FoodItemResponse> getAllFoodItems() {
        return foodItemRepository.findAll().stream()
                .map(foodItem -> new FoodItemResponse(
                        foodItem.getOrderItem_id(),
                        foodItem.getName(),
                        foodItem.getSpice_level(),
                        foodItem.getCuisine_type(),
                        foodItem.getQuantity(),
                        foodItem.getDescription(),
                        foodItem.getAvailability(),
                        foodItem.getVisibility(),
                        (foodItem.getPrice()),
                        (foodItem.getCompany() != null ?
                                new CompanyResponseIdName(
                                      foodItem.getCompany().getCompany_id(),
                                      foodItem.getCompany().getName()
                                )
                                : null)
                ))
        .toList();
    }

    @Override
    public List<FoodItemResponse> getFoodItemsByCompany(Long id) {
        return null;
    }
}
