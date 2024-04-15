package edu.miu.cs.cs489.lab7.adsapp.dto.patient;

import edu.miu.cs.cs489.lab7.adsapp.dto.address.AddressRequest;

public record PatientRequest(
        String lastName,
        AddressRequest primaryAddress
) {
}
