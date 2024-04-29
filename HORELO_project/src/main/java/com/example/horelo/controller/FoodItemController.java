package com.example.horelo.controller;

import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.service.inface.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("horelo/menu")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("")
    public List<FoodItemResponse> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }


}
