package edu.miu.cs.cs489.lab7.adsapp.service;

import edu.miu.cs.cs489.lab7.adsapp.model.Address;
import edu.miu.cs.cs489.lab7.adsapp.dto.address.AddressResponse2;

import java.util.List;

public interface AddressService {

    Address addNewAddress(Address newAddress);
    List<AddressResponse2> getAllAddresses();

    void deleteAddressById(Integer addressId);

}
