package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "surgeries")
@Data@AllArgsConstructor@NoArgsConstructor

public class Surgery {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgery_id;
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address location_address;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
public Surgery(String name){
    this.name = name;
}

}
