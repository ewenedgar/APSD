package com.example.horelo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredient_id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String description;
    //private Availability availability;
    private String serve_type;// extra // side // menuItem

   /* @ManyToOne
    @JoinColumn(name="orderItem_id", nullable = false)
    private OrderItem orderItem;

    */
}
