package com.example.lab6.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity(name="appointments")
public class Appointment {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentID;

    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "dentist_id", unique = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id", unique = false)
    private Patient patient;

    @Nonnull
    @ManyToOne
    @JoinColumn(name="publisher_id", unique = false)
    private Surgery surgery;
}
