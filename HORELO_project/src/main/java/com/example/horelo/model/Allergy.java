package com.example.horelo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Allergy {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allergy_id;
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotBlank(message="description cannot be empty")
    private String description;
    @ManyToOne
    @JsonManagedReference
    @JoinTable(
            name = "user_allergy",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id"))
    private User user;

}
