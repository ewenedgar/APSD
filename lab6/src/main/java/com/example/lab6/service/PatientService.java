package com.example.lab6.service;

import com.example.lab6.model.Patient;
import com.example.lab6.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
   Patient addNewPatient(Patient newPatient){
       return patientRepository.save(newPatient);
   }
    void removePatient(Integer id){
       patientRepository.deleteAllById(Collections.singleton(id));
    }

   Patient updatePatient (Integer id,Patient newPatient){
       return patientRepository.save(newPatient);
   }

    List<Patient> getAllPatient(){
       return patientRepository.findAll();
    }
   Optional<Patient> getPatientById(Integer id){
       return patientRepository.findById(id);
   }
}
