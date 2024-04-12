package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab6.model.Address;

import java.util.List;

@Entity(name= "dentist")
@Data@AllArgsConstructor@NoArgsConstructor
@DiscriminatorValue("dentist")
public class Dentist extends Person{
    @OneToMany(mappedBy = "dentist")
    List<Appointment> appointments;
}
