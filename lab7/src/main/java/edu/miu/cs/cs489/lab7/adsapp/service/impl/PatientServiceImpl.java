package edu.miu.cs.cs489.lab7.adsapp.service.impl;

import edu.miu.cs.cs489.lab7.adsapp.dto.address.AddressResponse;
import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab7.adsapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.lab7.adsapp.model.Address;
import edu.miu.cs.cs489.lab7.adsapp.model.Patient;
import edu.miu.cs.cs489.lab7.adsapp.service.PatientService;
import edu.miu.cs.cs489.lab7.adsapp.repository.AddressRepository;
import edu.miu.cs.cs489.lab7.adsapp.repository.PatientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

//    @Autowired
    private PatientRepository patientRepository;
    private AddressRepository addressRepository;

//    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository,
                                AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

//    public PatientServiceImpl() {
//
//    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll(Sort.by("name"))
                .stream()
//                .sorted(Comparator.comparing(Patient::getName))
                .map(p -> new PatientResponse(
                        p.getPatientId(),
                        p.getName(),
                        (p.getPrimaryAddress()!=null)?new AddressResponse(
                                p.getPrimaryAddress().getAddressId(),
                                p.getPrimaryAddress().getStreet(),
                                p.getPrimaryAddress().getCity(),
                                p.getPrimaryAddress().getState(),
                                p.getPrimaryAddress().getZipCode()
                        ):null
                )).toList();
    }

    @Override
    public PatientResponse addNewPatient(PatientRequest patientRequest) {
        var newPatient = new Patient(null,
                patientRequest.name(), new Address(null,
                patientRequest.primaryAddress().street(),
                patientRequest.primaryAddress().city(),
                patientRequest.primaryAddress().state(),
                patientRequest.primaryAddress().zipCode()));
        var savedPatient =  patientRepository.save(newPatient);
        return new PatientResponse(
                savedPatient.getPatientId(),
                savedPatient.getName(),
                new AddressResponse(
                        savedPatient.getPrimaryAddress().getAddressId(),
                        savedPatient.getPrimaryAddress().getStreet(),
                        savedPatient.getPrimaryAddress().getCity(),
                        savedPatient.getPrimaryAddress().getState(),
                        savedPatient.getPrimaryAddress().getZipCode()
                )
        );
    }

    @Override
    public Patient getPatientId(Integer patientId) throws PatientNotFoundException {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found",
                        patientId)));
    }

    @Override
    public Patient updatePatient(Integer patientId, Patient editedPatient) {
        var patient = patientRepository.findById(patientId).orElse(null);
        if(patient != null ) {
            patient.setName(editedPatient.getName());
            if(patient.getPrimaryAddress()!=null) {
                var address = patient.getPrimaryAddress();
                address.setStreet(editedPatient.getPrimaryAddress().getStreet());
                address.setCity(editedPatient.getPrimaryAddress().getCity());
                address.setState(editedPatient.getPrimaryAddress().getState());
                address.setZipCode(editedPatient.getPrimaryAddress().getZipCode());
            } else {
                var newAddress = new Address();
                newAddress.setStreet(editedPatient.getPrimaryAddress().getStreet());
                newAddress.setCity(editedPatient.getPrimaryAddress().getCity());
                newAddress.setState(editedPatient.getPrimaryAddress().getState());
                newAddress.setZipCode(editedPatient.getPrimaryAddress().getZipCode());
                newAddress.setPatient(patient);
                patient.setPrimaryAddress(newAddress);
            }
            return patientRepository.save(patient);
        } else {
            return null;
        }
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public void deletePatientAddressById(Integer patientId) {
        var patient = patientRepository.findById(patientId).orElse(null);
        if(patient != null) {
            var address = patient.getPrimaryAddress();
            if(address != null) {
//                addressRepository.deleteById(address.getAddressId());
//                patient.setPrimaryAddress(null);
//                patientRepository.save(patient);

                patient.setPrimaryAddress(null);
                patientRepository.save(patient);
                addressRepository.deleteById(address.getAddressId());
            }
        }
    }

    @Override
    public List<Patient> getPatientByNameStart(String nameStart) {
        return patientRepository.findPatientByNameIsStartingWith(nameStart);
    }

    @Override
    public List<Patient> searchPatient(String searchString) {
        return patientRepository.findPatientsByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContaining(
                searchString, searchString, searchString, searchString
        );
    }
}
