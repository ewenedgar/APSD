package edu.miu.cs.cs489.lab7.adsapp.service;

import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab7.adsapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.lab7.adsapp.model.Patient;

import java.util.List;

public interface PatientService {

    List<PatientResponse> getAllPatients();

    PatientResponse addNewPatient(PatientRequest patientRequest);

    Patient getPatientId(Integer patientId) throws PatientNotFoundException;

    Patient updatePatient(Integer patientId, Patient editedPublished);

    void deletePatientById(Integer patientId);

    void deletePatientAddressById(Integer patientId);

    List<Patient> getPatientByNameStart(String nameStart);

    List<Patient> searchPatient(String searchString);

}
