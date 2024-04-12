package com.example.lab6.service;

import com.example.lab6.model.Surgery;
import com.example.lab6.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
    @Autowired
    SurgeryRepository surgeryRepository;
    Surgery addNewSurgery(Surgery newSurgery){
        return surgeryRepository.save(newSurgery);
    }
    void removeSurgery(Integer id){
        surgeryRepository.deleteById(id);
    }

    Surgery updateSurgery (Integer id,Surgery newSurgery){
        return surgeryRepository.save(newSurgery);
    }

    List<Surgery> getAllSurgery(){
        return surgeryRepository.findAll();
    }
    Optional<Surgery> getSurgeryById(Integer id){
        return surgeryRepository.findById(id);
    }
}
