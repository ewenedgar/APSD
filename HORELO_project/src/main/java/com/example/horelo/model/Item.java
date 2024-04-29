package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@AllArgsConstructor
@NoArgsConstructor@Data
public class Item {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotBlank(message="description cannot be empty")
    private String description;
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    @Embedded
    private Price price;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="customerOrder_id",nullable = false)
    private CustomerOrder customerOrder;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="company_id", nullable = false)
    private Company company;


}
