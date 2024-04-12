package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab6.model.Address;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "patients")
@Data@AllArgsConstructor@NoArgsConstructor
@DiscriminatorValue("patient")
public class Patient extends Person{
    private LocalDate dob;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address home_address;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(Integer id,String firstName, String lastName, String email,String phone, LocalDate dob, Address address) {
        super(id, firstName, lastName,email,phone);
        this.dob = dob;
        this.home_address = address;
    }
}
