package com.example.horelo.service.inface;

import com.example.horelo.dto.order.CustomerOrderResponse;
import com.example.horelo.dto.order.CustomerOrderResponse2;
import com.example.horelo.dto.order.CustomerOrderResponse3;
import com.example.horelo.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {
    CustomerOrder addNewOrder(CustomerOrder newOrder);
    CustomerOrderResponse3 getCustomerOrdersById(Long id);

    List<CustomerOrderResponse> getAllOrders();
}
