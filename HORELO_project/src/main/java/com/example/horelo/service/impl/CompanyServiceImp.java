package com.example.horelo.service.impl;

import com.example.horelo.dto.address.AddressResponse;
import com.example.horelo.dto.company.*;
import com.example.horelo.dto.ingredient.IngredientResponse;
import com.example.horelo.dto.item.ItemResponse;
import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.dto.orderItem.FoodItemResponse3;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.Address;
import com.example.horelo.model.Company;
import com.example.horelo.respository.CompanyRepository;
import com.example.horelo.service.inface.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImp  implements CompanyService
         {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company addNewCompany(Company newCompany) {
        return companyRepository.save(newCompany);
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        return companyRepository.findAll().stream().map(
                c -> new CompanyResponse(
                        c.getCompany_id(),
                        c.getPhone_number(),
                        c.getName(),
                        c.getVisibility(),
                        c.getEmail()
                )
        ).toList();
    }

    @Override
    public List<CompanyItemResponse> getCompanyItems(Long id) {
        Optional<Company> companyOpt = companyRepository.findById(id);

        if(companyOpt.isPresent()) {
            Company c = companyOpt.get();
            List<ItemResponse> itemResponses = c.getItemList() != null ?
                    c.getItemList().stream()
                            .map(
                                    item -> new ItemResponse(item.getItem_id(),
                                            item.getName(), item.getDescription(),
                                            item.getQuantity(),
                                            item.getPrice())
                            ).collect(Collectors.toList()) : List.of();
            return List.of(new CompanyItemResponse(
                    c.getCompany_id(),
                    c.getPhone_number(),
                    c.getName(),
                    c.getEmail(),
                    itemResponses
            ));
        } else {
            return List.of(); // Or throw an exception if appropriate
        }
    }

    @Override
    public List<CompanyUserResponse> getCompanyUsers(Long id) {
        Optional<Company> companyOpt = companyRepository.findById(id);
        if(companyOpt.isPresent()){
            Company c = companyOpt.get();
            List<UserResponse> userResponses = c.getUsers() != null ?
        c.getUsers().stream().map(
                user -> new UserResponse(user.getUser_id(),
                        user.getFirst_name(),
                        user.getLast_name(),
                        user.getPhone_number(),
                        user.getEmail())
        ).toList()
        : List.of();
            return List.of(new CompanyUserResponse(
                    c.getCompany_id(),
                    c.getPhone_number(),
                    c.getName(),
                    c.getVisibility(),
                    c.getEmail(),
                    userResponses
            ));
        }else {
            return null;
        }
    }

    @Override
    public List<CompanyAddressResponse> getCompanyAddress(Long id) {
        Optional<Company> companyOpt = companyRepository.findById(id);

        // Check if the company is present
        if (companyOpt.isPresent()) {
            Company c = companyOpt.get();
            // Assuming the company might have only one primary address to return as part of the response
            AddressResponse addressResponse = null;
            if (c.getPrimary_address() != null) {
                Address primaryAddress = c.getPrimary_address();
                addressResponse = new AddressResponse(
                        primaryAddress.getAddress_id(),
                        primaryAddress.getStreet(),
                        primaryAddress.getCity(),
                        primaryAddress.getState(),
                        primaryAddress.getZipCode()
                );
            }
            CompanyAddressResponse companyAddressResponse = new CompanyAddressResponse(
                    c.getCompany_id(),
                    c.getPhone_number(),
                    c.getName(),
                    c.getEmail(),
                    addressResponse
            );
            return List.of(companyAddressResponse);
        } else {
            return Collections.emptyList(); // Return an empty list if no company is found
        }
    }

    @Override
    public List<CompanyOrderItemResponse> getCompanyOrderItems(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company c = companyOptional.get();
            List<FoodItemResponse3> orderItemResponses = c.getOrder_items_list()
                    != null ?
                   c.getOrder_items_list().stream().map(
                           foodItem -> new FoodItemResponse3(
                                   foodItem.getOrderItem_id(),
                                   foodItem.getName(),
                                   foodItem.getSpice_level(),
                                   foodItem.getCuisine_type(),
                                   foodItem.getQuantity(),
                                   foodItem.getDescription(),
                                   foodItem.getAvailability(),
                                   foodItem.getVisibility(),
                                   (foodItem.getPrice())
                           )
                   ).toList()   : List.of();
                CompanyOrderItemResponse companyOderItemResponse = new CompanyOrderItemResponse(
                    c.getCompany_id(),
                    c.getPhone_number(),
                    c.getName(),
                    c.getEmail(),
                    orderItemResponses
            );

            return List.of(companyOderItemResponse);
        }
        else {
            return List.of();
        }
    }

    @Override
    public List<CompanyOrderResponse> getCompanyOrders(Long id) {
        /*
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company c = companyOptional.get();
            List<OrderItemResponse> orderItemResponses = c.getOrder_items_list()
                    != null ?
                    c.getOrder_items_list().stream().map(
                            orderItem -> new OrderItemResponse(
                                    orderItem.getOrderItem_id(),
                                    orderItem.getName(),
                                    orderItem.getSpice_level(),
                                    orderItem.getCuisine_type(),
                                    orderItem.getQuantity(),
                                    orderItem.getPrice()
                            )
                    ).toList()   : List.of();
            List<OrderResponse> orderResponses = c.getOrder_list() != null ?
                    c.getOrder_list().stream().map(
                            order -> new OrderResponse(
                                    order.getOrder_id(),
                                    order.getStatus(),
                                    order.getOrder_date_time(),
                                    order.getType(),

                                    (order.getUser() != null ?
                                            new UserResponse(
                                                    order.getUser().getUser_id(),
                                                    order.getUser().getFirst_name(),
                                                    order.getUser().getLast_name(),
                                                    order.getUser().getPhone_number()
                                            ) : null
                            ),
                                    orderItemResponses

                    )).toList()  : List.of();
            CompanyOrderResponse companyOderResponse = new CompanyOrderResponse(
                    c.getCompany_id(),
                    c.getPhone_number(),
                    c.getName(),
                    c.getEmail(),
                    orderResponses
            );

            return List.of(companyOderResponse);
        }
        else {
            return List.of();
        }

         */
        return null;
    }

    @Override
    public List<CompanyIngredientResponse> getCompanyIngredients(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company c = companyOptional.get();
            List<IngredientResponse> ingredientResponses = c.getIngredientList()
                    != null ?
                    c.getIngredientList().stream().map(
                            ingredient -> new IngredientResponse(
                                    ingredient.getIngredient_id(),
                                    ingredient.getName(),
                                    ingredient.getCompany(),
                                    ingredient.getDescription(),
                                    ingredient.getServe_type()
                            )
                    ).toList()   : List.of();
            CompanyIngredientResponse companyIngredientResponse = new CompanyIngredientResponse(
                    c.getCompany_id(),
                    c.getPhone_number(),
                    c.getName(),
                    c.getEmail(),
                    ingredientResponses
            );

            return List.of(companyIngredientResponse);
        }
        else {
            return List.of();
        }
    }


}
