package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="addresses")
@Data@AllArgsConstructor@NoArgsConstructor
public class Address {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer address_id;
    private String city;
    private String state;
    private String  zip;

    @OneToOne(mappedBy = "location_address")
    private Surgery surgery;

    @OneToOne(mappedBy = "home_address")
    private Patient patient;
}
