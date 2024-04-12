package com.example.lab6.repository;

import com.example.lab6.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
