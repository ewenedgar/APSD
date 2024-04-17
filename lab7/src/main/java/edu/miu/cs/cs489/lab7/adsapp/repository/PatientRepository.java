package edu.miu.cs.cs489.lab7.adsapp.repository;

import edu.miu.cs.cs489.lab7.adsapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "select p from Patient p")
    public List<Patient> getMyCustomListOfPatient();

    @Query(value = "select p from Patient p where p.lastName = :name")
    public Optional<Patient> getPatientByLastNameStart(String name);

    @Query(value = "SELECT * FROM `cs489-apsd-ads-db2`.patients p where p.lastname like 'Ap%'", nativeQuery = true)
    public Optional<Patient> getMyNativeCustomPatientByLastName(String name);

    // Using Query methods
    public List<Patient> findPatientByLastNameIsStartingWith(String strNameStart);


    List<Patient> findPatientsByLastNameContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_State(String searchString, String searchString1, String searchString2);
}

