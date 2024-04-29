package com.example.horelo.controller;

import com.example.horelo.dto.order.CustomerOrderResponse;
import com.example.horelo.dto.order.CustomerOrderResponse2;
import com.example.horelo.dto.order.CustomerOrderResponse3;
import com.example.horelo.respository.CustomerOrderRepository;
import com.example.horelo.service.inface.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horelo")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;
    @GetMapping("/order")
    public List<CustomerOrderResponse> getAllOrders(){
        return customerOrderService.getAllOrders();
    }
    @GetMapping("/order/{id}")
    public CustomerOrderResponse3 getOrderById(@PathVariable Long id){

        return customerOrderService.getCustomerOrdersById(id);
    }
}
