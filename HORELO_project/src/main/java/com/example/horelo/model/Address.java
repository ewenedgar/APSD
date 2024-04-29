package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    @NotBlank(message="street cannot be empty")
    private String street;
    @NotBlank(message="city cannot be empty")
    private String city;
    @NotBlank(message="state cannot be empty")
    private String state;
    @NotBlank(message="zip code cannot be empty")
    private String zipCode;

    @JsonBackReference
    @OneToOne(mappedBy ="primary_address")
    private User user;
    @JsonBackReference
    @OneToOne(mappedBy = "primary_address")
    private Company company;

}
