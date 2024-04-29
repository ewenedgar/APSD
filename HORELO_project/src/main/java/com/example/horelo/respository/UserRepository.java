package com.example.horelo.respository;

import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {




    @Query(value = "SELECT u FROM User u", nativeQuery = false)
    List<UserResponse> getAllUsers();
    @Query(value = "SELECT u.*, a.* FROM `cs489-apsd-ads-db2`.user_allergy ua " +
            "JOIN `cs489-apsd-ads-db2`.user u ON u.user_id = ua.user_id " +
            "JOIN `cs489-apsd-ads-db2`.allergy a ON a.allergy_id = ua.allergy_id where u.user_id = :id",
            nativeQuery = true)
    Optional<User> getCustomerAllergies(Long id);
}