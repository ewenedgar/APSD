package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab6.model.Address;

import java.util.ArrayList;
import java.util.List;

@Entity(name= "dentists")
@Data@AllArgsConstructor@NoArgsConstructor
@DiscriminatorValue("dentist")
public class Dentist extends Person{
    @OneToMany(mappedBy = "dentist")
    List<Appointment> appointments;

    public Dentist(Integer id,String firstName, String lastName, String email,String phone) {
        super(id, firstName, lastName,email,phone);
        this.appointments = new ArrayList<>();


    }
}
