package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodItem {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItem_id;
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotBlank(message="spice_level cannot be empty")
    private String spice_level;
    @NotBlank(message="cuisine_type cannot be empty")
    private String cuisine_type;
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    @NotBlank(message="description cannot be empty")
    private String description;
    private String availability;
    private String visibility;
    @Embedded
    private Price price;
    @JsonIgnore
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",nullable = false) // Maps to the owning Order entity
    private Company company;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    @JoinColumn(name="customerOrder_id",nullable = false)
    private CustomerOrder customerOrder;



}
