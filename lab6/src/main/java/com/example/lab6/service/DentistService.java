package com.example.lab6.service;

import com.example.lab6.model.Dentist;
import com.example.lab6.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
 @Autowired
 private DentistRepository dentistRepository;
 public Dentist addNewDentist(Dentist newDentist){
  return dentistRepository.save(newDentist);
 }
 void removeDentist(Integer id){
  var dent = dentistRepository.findById(id);
  //dentistRepository.delete(dent);
 }

 Optional<Dentist> updateDentist (Integer id, Dentist newDentist){
  Optional<Dentist> oldDent = dentistRepository.findById(id);
  if(oldDent.isPresent()){
   //oldDent.setName(newDentist.getName());
   return oldDent;
  }
  return null;
 }

 List<Dentist> getAllDentist(){
  return dentistRepository.findAll();
 }
 Optional<Dentist> getDentistById(Integer id){
  return dentistRepository.findById(id);
 }

}
