package com.example.horelo.service.impl;

import com.example.horelo.dto.address.AddressCompanyResponse;
import com.example.horelo.dto.address.AddressUserResponse;
import com.example.horelo.dto.company.CompanyResponse;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.Address;
import com.example.horelo.respository.AddressRepository;
import com.example.horelo.service.inface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addNewAddress(Address newAddress){
        return addressRepository.save(newAddress);
    }

    @Override
    public List<AddressUserResponse> getAllUserAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressUserResponse(
                        a.getAddress_id(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        (a.getUser() != null) ? new UserResponse(
                                a.getUser().getUser_id(),
                                a.getUser().getFirst_name(),
                                a.getUser().getLast_name(),
                                a.getUser().getPhone_number(),
                                a.getUser().getEmail()
                        ): null
                )).toList();
    }

    @Override
    public List<AddressUserResponse> getUserAddressByCity() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressUserResponse(
                        a.getAddress_id(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        (a.getUser() != null) ? new UserResponse(
                                a.getUser().getUser_id(),
                                a.getUser().getFirst_name(),
                                a.getUser().getLast_name(),
                                a.getUser().getPhone_number(),
                                a.getUser().getEmail()
                        ): null
                )).toList();
    }

    @Override
    public List<AddressCompanyResponse> getAddressByCompany() {
        return addressRepository.findAll()
                .stream()
                .map( a-> new AddressCompanyResponse(
                        a.getAddress_id(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        (a.getCompany() != null ?new CompanyResponse(
                                a.getCompany().getCompany_id(),
                                a.getCompany().getPhone_number(),
                                a.getCompany().getName(),
                                a.getCompany().getVisibility(),
                                a.getCompany().getEmail()
                        ) :null)
                )).toList();
    }


}
