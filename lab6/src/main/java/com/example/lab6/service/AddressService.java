package com.example.lab6.service;

import com.example.lab6.model.Address;
import com.example.lab6.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    Address addNewAddress(Address newAddress){
        return addressRepository.save(newAddress);
    }
}
