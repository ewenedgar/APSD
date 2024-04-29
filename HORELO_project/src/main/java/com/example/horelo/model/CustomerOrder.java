package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerOrder_id;
    private String status;
    private LocalDateTime date_time;
    private String delivery_type; //in-house / pick up
    private String special_requests;
    private String payment_type;
    private double total_price;
    private double discount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<FoodItem> orderItemList;
    @JsonIgnore
    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Item> itemList;

    public double setTotal_price() {
        return orderItemList.stream()
                .mapToDouble(item -> item.getPrice().getAmount() * item.getQuantity())
                .sum()
                +
                itemList.stream()
                        .mapToDouble(item -> item.getPrice().getAmount() * item.getQuantity())
                        .sum()
                ;
    }
}
