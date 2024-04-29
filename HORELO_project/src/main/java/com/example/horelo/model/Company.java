package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;
    @NotBlank(message="phone number cannot be empty")
    private String phone_number;
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotBlank(message="email cannot be empty")
    private String email;
    @NotBlank(message="open hours cannot be empty")
    private String open_hours;
    private String Visibility;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FoodItem> order_items_list;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items_list;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="address_id")@JsonManagedReference
    private Address primary_address;

    @ManyToMany
    @JoinTable(name = "user_company", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<User> users;


    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    private List<Item> itemList;
    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    private List<Ingredient> ingredientList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerOrder> customerOrder_list;
}
