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

    @Query(value = "select p from Patient p where p.name = :name")
    public Optional<Patient> getMyCustomPatientByName(String name);

    @Query(value = "SELECT * FROM `cs489-apsd-citylibrary-db2`.patients p where p.name like 'Ap%'", nativeQuery = true)
    public Optional<Patient> getMyNativeCustomPatientByName(String name);

    // Using Query methods
    public List<Patient> findPatientByNameIsStartingWith(String strNameStart);
    public List<Patient> findPatientsByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContaining(
            String name, String street, String city, String state
    );

//    SELECT p.*, a.* FROM `cs489-apsd-citylibrary-db2`.patients p
//    inner join `cs489-apsd-citylibrary-db2`.addresses a
//    on p.address_id = a.address_id
//    where p.name like '%CA%'
//    OR a.street like '%CA%'
//    OR a.city like '%CA%'
//    OR a.state like '%CA%'
}
