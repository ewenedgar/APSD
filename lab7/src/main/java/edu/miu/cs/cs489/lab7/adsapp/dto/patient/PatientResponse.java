package edu.miu.cs.cs489.lab7.adsapp.dto.patient;

import edu.miu.cs.cs489.lab7.adsapp.dto.address.AddressResponse;

public record PatientResponse(
        Integer patientId,
        String lastName,
        String firstName,
        AddressResponse primaryAddress
        ) {
}
