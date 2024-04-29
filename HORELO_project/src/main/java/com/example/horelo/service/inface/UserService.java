package com.example.horelo.service.inface;

import com.example.horelo.dto.user.UserInfoResponse;
import com.example.horelo.dto.user.UserOrderResponse;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.User;

import java.util.List;

public interface UserService {
    User addNewUser(User newUser);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();
    UserInfoResponse getUserInfo(Long id);
    List<UserOrderResponse> getAllUserOrders(Long id);
}
