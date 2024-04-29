package com.example.horelo.service.impl;

import com.example.horelo.dto.address.AddressResponse;
import com.example.horelo.dto.allergy.AllergyResponse;
import com.example.horelo.dto.order.CustomerOrderResponse2;
import com.example.horelo.dto.orderItem.FoodItemResponse;
import com.example.horelo.dto.user.UserInfoResponse;
import com.example.horelo.dto.user.UserOrderResponse;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.User;
import com.example.horelo.respository.UserRepository;
import com.example.horelo.service.inface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp  implements UserService{

    @Autowired
    private UserRepository userRepository;

    private UserResponse userDetail(Long id){
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return new UserResponse(user.getUser_id(), user.getFirst_name(),
                    user.getLast_name(),user.getPhone_number(), user.getEmail());
        } else {
            throw new RuntimeException("User not found with id: " + id);

        }
    }
private AddressResponse userAdd(Long id){
    Optional<User> userOpt = userRepository.findById(id);
    if (userOpt.isPresent()) {
        User user = userOpt.get();

        return new  AddressResponse(
                        user.getPrimary_address().getAddress_id(),
                        user.getPrimary_address().getStreet(),
                        user.getPrimary_address().getCity(),
                        user.getPrimary_address().getState(),
                        user.getPrimary_address().getZipCode()

        );
    } else {
        throw new RuntimeException("User not found with id: " + id);

    }
}
    private UserInfoResponse getUserInfos(Long id){
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            List<AllergyResponse> allergyResponses = user.getAllergyList() != null ?
                    user.getAllergyList().stream().map(
                            allergy -> new AllergyResponse(
                                    allergy.getAllergy_id(),
                                    allergy.getName(),
                                    allergy.getDescription()
                            )
                    ).toList() : Collections.emptyList();

            return new UserInfoResponse(user.getUser_id(),
                    user.getFirst_name(),
                    user.getLast_name(),
                    user.getPhone_number(),
                    user.getEmail(),
                    (user.getPrimary_address() != null) ?
                            userAdd(id) : null,
                    allergyResponses

            );
        } else {
            throw new RuntimeException("User not found with id: " + id);

        }
    }

    @Override
    public User addNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userDetail(id);
    }
    @Override
    public UserInfoResponse getUserInfo(Long id){
        return getUserInfos(id);
    }
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(
                user -> new UserResponse(
                        user.getUser_id(),
                        user.getFirst_name(),
                        user.getLast_name(),
                        user.getPhone_number(),
                        user.getEmail()
                )
        ).toList();
    }



    @Override
    public List<UserOrderResponse> getAllUserOrders(Long id) {

        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()) {
            User u = userOpt.get();
            List<CustomerOrderResponse2> orderResponses = u.getCustomerOrders_list() != null ?
                    u.getCustomerOrders_list().stream().map(
                            order -> new CustomerOrderResponse2(
                                    order.getCustomerOrder_id(),
                                    order.getStatus(),
                                    order.getDate_time(),
                                    order.getDelivery_type(),
                                    order.getSpecial_requests(),
                                    order.getPayment_type(),
                                    order.getTotal_price(),
                                    order.getDiscount()
                                    //userDetail(id)
                                    /*,

                                    (order.getOrderItemList() != null ?

                                            order.getOrderItemList().stream().map(
                                                    orderItem -> new FoodItemResponse(
                                                            orderItem.getOrderItem_id(),
                                                            orderItem.getName(),                                                         orderItem.getSpice_level(),
                                                            orderItem.getCuisine_type(),
                                                            orderItem.getQuantity(),
                                                            orderItem.getPrice()
                                                    )
                                            ).toList()
                                        : List.of()
                                    ) */




                    )).toList()
                    : List.of();

            UserOrderResponse userOrderResponse = new UserOrderResponse(
                    u.getUser_id(),
                    u.getFirst_name(),
                    u.getLast_name(),
                    u.getPhone_number(),
                    u.getEmail(),
                    orderResponses
            );
            return List.of(userOrderResponse);
        } else return List.of();

        //return null;
    }

}
