package com.example.horelo.service.impl;

import com.example.horelo.dto.item.ItemResponse;
import com.example.horelo.dto.order.CustomerOrderResponse;
import com.example.horelo.dto.order.CustomerOrderResponse3;
import com.example.horelo.dto.orderItem.FoodItemResponse2;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.CustomerOrder;
import com.example.horelo.respository.CustomerOrderRepository;
import com.example.horelo.service.inface.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderServiceImp implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;


    private CustomerOrderResponse3 getOrderById(Long id){
        Optional<CustomerOrder>   custOpt =  customerOrderRepository.findById(id);
        if(custOpt.isPresent()){
            CustomerOrder customerOrder = custOpt.get();
            List<ItemResponse> itemResponses = customerOrder.getItemList() != null ?
                    customerOrder.getItemList().stream().map(
                            item -> new ItemResponse(
                                    item.getItem_id(),
                                    item.getName(),
                                    item.getDescription(),
                                    item.getQuantity(),
                                    item.getPrice()
                            )
                    ).toList()
                    : List.of();
            List<FoodItemResponse2> foodItemResponses = customerOrder.getOrderItemList() != null ?
                    customerOrder.getOrderItemList().stream().map(
                            foodItem -> new FoodItemResponse2(
                                    foodItem.getOrderItem_id(),
                                    foodItem.getName(),
                                    foodItem.getSpice_level(),
                                    foodItem.getCuisine_type(),
                                    foodItem.getQuantity(),
                                    foodItem.getDescription()
                            )
                    ).toList()
            : List.of();
            return new CustomerOrderResponse3(
                    customerOrder.getCustomerOrder_id(),
                    customerOrder.getStatus(),
                    customerOrder.getDate_time(),
                    customerOrder.getDelivery_type(),
                    customerOrder.getSpecial_requests(),
                    customerOrder.getPayment_type(),
                    customerOrder.getTotal_price(),
                    customerOrder.getDiscount(),
                    (customerOrder.getUser() != null ? new UserResponse(
                            customerOrder.getUser().getUser_id(),
                            customerOrder.getUser().getFirst_name(),
                            customerOrder.getUser().getLast_name(),
                            customerOrder.getUser().getPhone_number(),
                            customerOrder.getUser().getEmail()
                    ): null),
                    foodItemResponses,
                    itemResponses
            );
        }
        else
            return null;
    }
    @Override
    public CustomerOrder addNewOrder(CustomerOrder newOrder) {
        return null;
    }

    @Override
    public List<CustomerOrderResponse> getAllOrders() {
        return customerOrderRepository
                .findAll()
                .stream()
                .map(customerOrder -> new CustomerOrderResponse(
                        customerOrder.getCustomerOrder_id(),
                        customerOrder.getStatus(),
                        customerOrder.getDate_time(),
                        customerOrder.getDelivery_type(),
                        customerOrder.getSpecial_requests(),
                        customerOrder.getPayment_type(),
                        customerOrder.getTotal_price(),
                        customerOrder.getDiscount(),
                        (customerOrder.getUser() != null ? new UserResponse(
                                customerOrder.getUser().getUser_id(),
                                customerOrder.getUser().getFirst_name(),
                                customerOrder.getUser().getLast_name(),
                                customerOrder.getUser().getPhone_number(),
                                customerOrder.getUser().getEmail()
                        ) :null)
                ))
                .toList();
    }
    @Override
    public CustomerOrderResponse3 getCustomerOrdersById(Long id){

        Optional<CustomerOrder>   custOpt =  customerOrderRepository.findById(id);
        if(custOpt.isPresent()){
            CustomerOrder customerOrder = custOpt.get();
            List<ItemResponse> itemResponses = customerOrder.getItemList() != null ?
                    customerOrder.getItemList().stream().map(
                          item -> new ItemResponse(
                                  item.getItem_id(),
                                  item.getName(),
                                  item.getDescription(),
                                  item.getQuantity(),
                                  item.getPrice()
                          )
                    ).toList()
            : List.of();
            List<FoodItemResponse2> foodItemResponses = customerOrder.getOrderItemList() != null ?
                    customerOrder.getOrderItemList().stream().map(
                            foodItem -> new FoodItemResponse2(
                                    foodItem.getOrderItem_id(),
                                    foodItem.getName(),
                                    foodItem.getSpice_level(),
                                    foodItem.getCuisine_type(),
                                    foodItem.getQuantity(),
                                    foodItem.getDescription()
                            )
                    ).toList()
                    : List.of();
            return new CustomerOrderResponse3(
                    customerOrder.getCustomerOrder_id(),
                    customerOrder.getStatus(),
                    customerOrder.getDate_time(),
                    customerOrder.getDelivery_type(),
                    customerOrder.getSpecial_requests(),
                    customerOrder.getPayment_type(),
                    customerOrder.getTotal_price(),
                    customerOrder.getDiscount(),
                    (customerOrder.getUser() != null ? new UserResponse(
                            customerOrder.getUser().getUser_id(),
                            customerOrder.getUser().getFirst_name(),
                            customerOrder.getUser().getLast_name(),
                            customerOrder.getUser().getPhone_number(),
                            customerOrder.getUser().getEmail()
                    ): null),
                    foodItemResponses,
                    itemResponses
            );
        }
        else
            return null;
 }
}
