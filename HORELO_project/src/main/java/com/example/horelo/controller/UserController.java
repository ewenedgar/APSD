package com.example.horelo.controller;

import com.example.horelo.dto.user.UserInfoResponse;
import com.example.horelo.dto.user.UserOrderResponse;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.service.inface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/horelo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Long id){
        Optional<UserResponse> u = Optional.ofNullable(userService.getUserById(id));
        return u.orElse(null);
    }
    @GetMapping("/user/{id}/info")
    public UserInfoResponse getUserinfo(@PathVariable Long id){
        Optional<UserInfoResponse> u = Optional.ofNullable(userService.getUserInfo(id));

        return u.orElse(null);
    }
    @GetMapping("/user/{id}/orders")
    public List<UserOrderResponse> getUserOrders(@PathVariable Long id){


        return userService.getAllUserOrders(id);
    }



}
