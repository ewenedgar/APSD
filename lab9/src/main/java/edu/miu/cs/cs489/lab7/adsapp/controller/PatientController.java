package edu.miu.cs.cs489.lab7.adsapp.controller;

import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab7.adsapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.lab7.adsapp.model.Patient;
import edu.miu.cs.cs489.lab7.adsapp.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<PatientResponse>> listPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }


    @GetMapping(value = "/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientId(patientId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<PatientResponse> registerNewPatient(@Valid @RequestBody PatientRequest patientRequest) {
        return new ResponseEntity<>(patientService.addNewPatient(patientRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId,
                                                     @RequestBody Patient editedPatient) {
        return new ResponseEntity<>(patientService.updatePatient(patientId, editedPatient),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/address/delete/{patientId}")
    public ResponseEntity<Void> deletePatientAddressById(@PathVariable Integer patientId) {
        patientService.deletePatientAddressById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatient(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }

}
