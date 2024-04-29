package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotBlank(message="first_name cannot be empty")
    private String first_name;
    @NotBlank(message="last_name cannot be empty")
    private String last_name;
    @NotBlank(message="phone_number cannot be empty")
    private String phone_number;
    private String email;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")@JsonManagedReference
    private Address primary_address;

    /*
    @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<Company> company_list;

     */
    @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<CustomerOrder> customerOrders_list;





    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Allergy> allergyList;


}
