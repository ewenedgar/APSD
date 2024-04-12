package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab6.model.Address;

import java.util.List;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
@DiscriminatorValue("patient")
public class Patient extends Person{

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address home_address;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
