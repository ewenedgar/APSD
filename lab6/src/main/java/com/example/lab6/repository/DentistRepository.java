package com.example.lab6.repository;

import com.example.lab6.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
