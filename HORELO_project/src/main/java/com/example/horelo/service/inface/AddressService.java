package com.example.horelo.service.inface;

import com.example.horelo.dto.address.AddressCompanyResponse;
import com.example.horelo.dto.address.AddressResponse;
import com.example.horelo.dto.address.AddressUserResponse;
import com.example.horelo.model.Address;

import java.util.List;

public interface AddressService {
    Address addNewAddress(Address newAddress);

    //List<AddressResponse> getAllAddresses();

    List<AddressUserResponse> getAllUserAddresses();

    List<AddressUserResponse> getUserAddressByCity();

    List<AddressCompanyResponse> getAddressByCompany();
    //void deleteAddressByI(Long address_id);


}
