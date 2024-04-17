package edu.miu.cs.cs489.lab7.adsapp.service.impl;

import edu.miu.cs.cs489.lab7.adsapp.model.Address;
import edu.miu.cs.cs489.lab7.adsapp.dto.address.AddressResponse2;
import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientResponse2;
import edu.miu.cs.cs489.lab7.adsapp.repository.AddressRepository;
import edu.miu.cs.cs489.lab7.adsapp.service.AddressService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public List<AddressResponse2> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressResponse2(
                        a.getAddressId(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        (a.getPatient()!= null)?new PatientResponse2(
                                a.getPatient().getPatientId(),
                                a.getPatient().getLastName()
                        ): null
                )).toList();
    }
    @Override
    public List<AddressResponse2> getAllAddressesSortedByCity() {
        return addressRepository.findAll(Sort.by("city"))
                .stream()
                .map(a -> new AddressResponse2(
                        a.getAddressId(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        (a.getPatient()!= null)?new PatientResponse2(
                                a.getPatient().getPatientId(),
                                a.getPatient().getLastName()
                        ): null
                )).toList();
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        addressRepository.deleteById(addressId);
    }


}
